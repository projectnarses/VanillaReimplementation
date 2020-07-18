
package net.minestom.vanilla.generation.dimension.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Generator {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("seed")
    @Expose
    private int seed;
    @SerializedName("biome_source")
    @Expose
    private BiomeSource biomeSource;
    @SerializedName("settings")
    @Expose
    private String settings;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Generator() {
    }

    /**
     * 
     * @param settings
     * @param seed
     * @param biomeSource
     * @param type
     */
    public Generator(String type, int seed, BiomeSource biomeSource, String settings) {
        super();
        this.type = type;
        this.seed = seed;
        this.biomeSource = biomeSource;
        this.settings = settings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Generator withType(String type) {
        this.type = type;
        return this;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public Generator withSeed(int seed) {
        this.seed = seed;
        return this;
    }

    public BiomeSource getBiomeSource() {
        return biomeSource;
    }

    public void setBiomeSource(BiomeSource biomeSource) {
        this.biomeSource = biomeSource;
    }

    public Generator withBiomeSource(BiomeSource biomeSource) {
        this.biomeSource = biomeSource;
        return this;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public Generator withSettings(String settings) {
        this.settings = settings;
        return this;
    }

}
