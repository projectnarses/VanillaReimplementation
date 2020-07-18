
package net.minestom.vanilla.generation.dimension.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimension {

    @SerializedName("generator")
    @Expose
    private Generator generator;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Dimension() {
    }

    /**
     * 
     * @param generator
     * @param type
     */
    public Dimension(Generator generator, String type) {
        super();
        this.generator = generator;
        this.type = type;
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public Dimension withGenerator(Generator generator) {
        this.generator = generator;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Dimension withType(String type) {
        this.type = type;
        return this;
    }

}
