
package net.minestom.vanilla.generation.dimension.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Biome {

    @SerializedName("biome")
    @Expose
    private String biome;
    @SerializedName("parameters")
    @Expose
    private Parameters parameters;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Biome() {
    }

    /**
     * 
     * @param biome
     * @param parameters
     */
    public Biome(String biome, Parameters parameters) {
        super();
        this.biome = biome;
        this.parameters = parameters;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public Biome withBiome(String biome) {
        this.biome = biome;
        return this;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Biome withParameters(Parameters parameters) {
        this.parameters = parameters;
        return this;
    }

}
