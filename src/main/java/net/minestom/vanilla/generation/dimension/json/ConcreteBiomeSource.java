package net.minestom.vanilla.generation.dimension.json;

import de.articdive.jnoise.JNoise;
import net.minestom.vanilla.math.FiveDimensionalVoronoiMap;

/**
 * Represents a biome source for the {@link net.minestom.vanilla.generation.DimensionBasedGenerator}
 */
public class ConcreteBiomeSource {
// TODO: only supports minecraft:multi_noise for the moment

    private FiveDimensionalVoronoiMap<Biome> biomes = new FiveDimensionalVoronoiMap<>();
    private JNoise temperature = JNoise.newBuilder().perlin().setSeed((int) System.currentTimeMillis()).build();
    private JNoise altitude = JNoise.newBuilder().perlin().setSeed((int) (-System.currentTimeMillis())).build();
    private JNoise humidity = JNoise.newBuilder().perlin().setSeed((int) (System.currentTimeMillis()+10)).build();
    private JNoise weirdness = JNoise.newBuilder().perlin().setSeed((int) (System.currentTimeMillis()-10)).build();

    public ConcreteBiomeSource(BiomeSource source) {
        if( ! "minecraft:multi_noise".equals(source.getType())) {
            throw new UnsupportedOperationException("Unsupported biome source type: "+source.getType());
        }
        for(Biome b : source.getBiomes()) {
            var params = b.getParameters();
            biomes.add(new FiveDimensionalVoronoiMap.Vec5D<>(params.getTemperature(), params.getAltitude(), params.getHumidity(), params.getWeirdness(), params.getOffset(), b));
        }
    }

    public Biome get(int x, int y, int z) {
        double nx = x/80.0;
        double ny = y/160.0;
        double nz = z/80.0;
        double temp = temperature.getNoise(nx, ny, nz)*2.0;
        double alt = altitude.getNoise(nx/16.0, ny/16.0, nz/16.0)*2.0;
        double hum = humidity.getNoise(nx*2.0, ny*2.0, nz*2.0)*2.0;
        double weird = weirdness.getNoise(nx/32.0, ny/32.0, nz/32.0)*2.0;
        return biomes.get(temp, alt, hum, weird, 0.0).getUserObject();
    }
}
