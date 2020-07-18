
package net.minestom.vanilla.generation.worldgen.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SurfaceBuilder {

    @SerializedName("config")
    @Expose
    private Config config;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SurfaceBuilder() {
    }

    /**
     * 
     * @param name
     * @param config
     */
    public SurfaceBuilder(Config config, String name) {
        super();
        this.config = config;
        this.name = name;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
