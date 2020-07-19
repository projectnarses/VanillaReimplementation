package net.minestom.vanilla.generation;

import com.google.gson.Gson;
import de.articdive.jnoise.JNoise;
import net.minestom.server.instance.Biome;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.ChunkGenerator;
import net.minestom.server.instance.ChunkPopulator;
import net.minestom.server.instance.batch.ChunkBatch;
import net.minestom.server.instance.block.Block;
import net.minestom.server.registry.Registries;
import net.minestom.server.registry.ResourceGatherer;
import net.minestom.server.utils.NamespaceID;
import net.minestom.server.utils.thread.MinestomThread;
import net.minestom.vanilla.generation.dimension.json.ConcreteBiomeSource;
import net.minestom.vanilla.generation.dimension.json.Dimension;
import net.minestom.vanilla.generation.dimension.json.Generator;
import net.minestom.vanilla.generation.worldgen.json.SurfaceBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Generator that builds a dimension based on a Minecraft dimension json
 */
public class DimensionBasedGenerator extends ChunkGenerator {
    // FIXME Currently a WIP, possibly terribly inefficient and incorrect

    private final int SEA_LEVEL = 63;
    private final Dimension dimension;
    private final Generator generator;
    private final Map<String, net.minestom.vanilla.generation.biome.json.Biome> biomeCache = new ConcurrentHashMap<>();
    private final Map<String, SurfaceBuilder> surfaceCache = new ConcurrentHashMap<>();
    private final Gson gson = new Gson();
    private Field chunkField;

    private JNoise noise = JNoise.newBuilder().openSimplex().build();
    private ConcreteBiomeSource biomeSource;

    public DimensionBasedGenerator(Dimension dimension) {
        this.dimension = dimension;
        generator = dimension.getGenerator();
        biomeSource = new ConcreteBiomeSource(generator.getBiomeSource());

        try {
            chunkField = ChunkBatch.class.getDeclaredField("chunk");
            chunkField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateChunkData(ChunkBatch batch, int chunkX, int chunkZ) {
        Chunk chunk = null;
        try {
            chunk = (Chunk) chunkField.get(batch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // bedrock
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                batch.setBlock(x, 0, z, Block.BEDROCK);
            }
        }

        final Chunk finalChunk = chunk;

        // """surface"""
        MinestomThread threads = new MinestomThread(4, "DimensionBasedGenerator-Pool");
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                final int finalX = x;
                final int finalZ = z;
                threads.execute(() -> generateColumn(batch, finalChunk, chunkX, chunkZ, finalX, finalZ));
            }
        }
        threads.shutdown();
        try {
            threads.awaitTermination(1000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateColumn(ChunkBatch batch, Chunk chunk, int chunkX, int chunkZ, int x, int z) {
        // TODO: WIP, remove
        // TODO: support custom blocks (VanillaBlock)
        int posX = chunkX*16+x;
        int posZ = chunkZ*16+z;
        net.minestom.vanilla.generation.biome.json.Biome biome = getBiome(posX, 0, posZ);
        SurfaceBuilder surfaceBuilder = getSurfaceBuilder(biome.getSurfaceBuilder());
        Block top = Registries.getBlock(surfaceBuilder.getConfig().getTopMaterial().getName());
        Block under = Registries.getBlock(surfaceBuilder.getConfig().getUnderMaterial().getName());
        Block underwater = Registries.getBlock(surfaceBuilder.getConfig().getUnderwaterMaterial().getName());
        double heightDelta = biome.getDepth() + Math.exp(0.5+Math.abs(biome.getDepth()))*Math.abs(noise.getNoise(posX/32.0, posZ/32.0))*8*Math.signum(biome.getDepth());
        int height = (int) (SEA_LEVEL+heightDelta);
        for (int y = 1; y < height; y++) {
            batch.setBlock(x, y, z, under);
        }

        // water
        for (int y = height; y <= SEA_LEVEL; y++) {
            batch.setBlock(x, y, z, Block.WATER);
        }

        if(height >= SEA_LEVEL) { // not underwater
            batch.setBlock(x, height, z, top);
        } else {
            batch.setBlock(x, height, z, underwater);
        }
    }

    private SurfaceBuilder getSurfaceBuilder(String surfaceBuilder) {
        return surfaceCache.computeIfAbsent(surfaceBuilder, name -> {
            NamespaceID id = NamespaceID.from(surfaceBuilder);
            return read(id, "configured_surface_builder", SurfaceBuilder.class);
        });
    }

    private net.minestom.vanilla.generation.biome.json.Biome getBiome(int x, int y, int z) {
        return biomeFromName(getBiomeName(x, y, z));
    }

    private String getBiomeName(int x, int y, int z) {
        return biomeSource.get(x, y, z).getBiome();
    }

    private net.minestom.vanilla.generation.biome.json.Biome biomeFromName(String biomeName) {
        return biomeCache.computeIfAbsent(biomeName, n -> {
            NamespaceID id = NamespaceID.from(biomeName);
            return read(id, "biome", net.minestom.vanilla.generation.biome.json.Biome.class);
        });
    }

    private <T> T read(NamespaceID id, String type, Class<T> clazz) {
        try(FileReader fr = new FileReader(new File(ResourceGatherer.DATA_FOLDER, "data/"+id.getDomain()+"/worldgen/"+type+"/"+id.getPath()+".json"))) {
            return gson.fromJson(fr, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int biomeIndex(int x, int y, int z) {
        return (y/4)*16 + (z/4)*4 + (x/4);
    }

    @Override
    public void fillBiomes(Biome[] biomes, int chunkX, int chunkZ) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // TODO: 3D biomes
                Biome biome = Registries.getBiome(getBiomeName(chunkX*16+x, 0, chunkZ*16+z));
                for (int y = 0; y < 256; y++) {
                    int index = biomeIndex(x, y, z);
                    biomes[index] = biome;
                }
            }
        }
    }

    @Override
    public List<ChunkPopulator> getPopulators() {
        // TODO
        return Collections.emptyList();
    }
}
