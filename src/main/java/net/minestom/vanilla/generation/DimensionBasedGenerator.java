package net.minestom.vanilla.generation;

import com.google.gson.Gson;
import de.articdive.jnoise.JNoise;
import net.minestom.server.instance.Biome;
import net.minestom.server.instance.ChunkGenerator;
import net.minestom.server.instance.ChunkPopulator;
import net.minestom.server.instance.batch.ChunkBatch;
import net.minestom.server.instance.block.Block;
import net.minestom.server.registry.Registries;
import net.minestom.server.registry.ResourceGatherer;
import net.minestom.server.utils.NamespaceID;
import net.minestom.vanilla.generation.dimension.json.Dimension;
import net.minestom.vanilla.generation.dimension.json.Generator;
import net.minestom.vanilla.generation.worldgen.json.SurfaceBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Generator that builds a dimension based on a Minecraft dimension json
 */
public class DimensionBasedGenerator extends ChunkGenerator {
    // FIXME Currently a WIP, possibly terribly inefficient and incorrect

    private final Dimension dimension;
    private final Generator generator;
    private final Map<String, net.minestom.vanilla.generation.biome.json.Biome> biomeCache = new ConcurrentHashMap<>();
    private final Map<String, SurfaceBuilder> surfaceCache = new ConcurrentHashMap<>();
    private final Gson gson = new Gson();

    private JNoise noise = JNoise.newBuilder().openSimplex().build();
    // TODO: 4D noise for minecraft:multinoise

    public DimensionBasedGenerator(Dimension dimension) {
        this.dimension = dimension;
        generator = dimension.getGenerator();
    }

    @Override
    public void generateChunkData(ChunkBatch batch, int chunkX, int chunkZ) {
        // bedrock
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                batch.setBlock(x, 0, z, Block.BEDROCK);
            }
        }

        // """surface"""
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // TODO: WIP, remove
                // TODO: support custom blocks (VanillaBlock)
                net.minestom.vanilla.generation.biome.json.Biome biome = getBiome(chunkX*16+x, 0, chunkZ*16+z);
                SurfaceBuilder surfaceBuilder = getSurfaceBuilder(biome.getSurfaceBuilder());
                Block top = Registries.getBlock(surfaceBuilder.getConfig().getTopMaterial().getName());
                Block under = Registries.getBlock(surfaceBuilder.getConfig().getUnderMaterial().getName());
                Block underwater = Registries.getBlock(surfaceBuilder.getConfig().getUnderwaterMaterial().getName());
                int posX = chunkX*16+x;
                int posZ = chunkZ*16+z;
                double heightDelta = noise.getNoise(posX/16.0, posZ/16.0);
                heightDelta -= biome.getDepth();
                int height = (int) (64 - heightDelta*16);
                for (int y = 1; y < height; y++) {
                    batch.setBlock(x, y, z, under);
                }

                // water
                for (int y = height; y < 64; y++) {
                    batch.setBlock(x, y, z, Block.WATER);
                }

                if(height >= 64) { // not underwater
                    batch.setBlock(x, height, z, top);
                } else {
                    batch.setBlock(x, height, z, underwater);
                }
            }
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
        // TODO: 3D biomes
        // TODO: proper selection
        String names[] = {
                "minecraft:ocean",
                "minecraft:plains",
                "minecraft:mushroom_fields",
                "minecraft:nether_wastes",
                "minecraft:nether_wastes",
                "minecraft:mountains",
                "minecraft:soul_sand_valley",
        };
        final int size = 50;
        return names[Math.abs(x/size+z/size) % names.length]; // TODO
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

    @Override
    public void fillBiomes(Biome[] biomes, int chunkX, int chunkZ) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 256; y++) {
                    int index = (y/4)*16 + (x/4)*4 + (z/4);
                    biomes[index] = Registries.getBiome(getBiomeName(chunkX*16+x, y, chunkZ*16+z));
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
