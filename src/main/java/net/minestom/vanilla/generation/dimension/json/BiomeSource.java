
package net.minestom.vanilla.generation.dimension.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BiomeSource {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("seed")
    @Expose
    private int seed;
    @SerializedName("biomes")
    @Expose
    private List<Biome> biomes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BiomeSource() {
    }

    /**
     * 
     * @param seed
     * @param biomes
     * @param type
     */
    public BiomeSource(String type, int seed, List<Biome> biomes) {
        super();
        this.type = type;
        this.seed = seed;
        this.biomes = biomes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BiomeSource withType(String type) {
        this.type = type;
        return this;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public BiomeSource withSeed(int seed) {
        this.seed = seed;
        return this;
    }

    public List<Biome> getBiomes() {
        return biomes;
    }

    public void setBiomes(List<Biome> biomes) {
        this.biomes = biomes;
    }

    public BiomeSource withBiomes(List<Biome> biomes) {
        this.biomes = biomes;
        return this;
    }

}
