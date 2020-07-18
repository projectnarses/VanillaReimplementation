
package net.minestom.vanilla.generation.worldgen.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopMaterial {

    @SerializedName("Name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TopMaterial() {
    }

    /**
     * 
     * @param name
     */
    public TopMaterial(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
