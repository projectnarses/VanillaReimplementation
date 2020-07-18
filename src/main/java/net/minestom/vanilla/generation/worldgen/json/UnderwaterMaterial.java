
package net.minestom.vanilla.generation.worldgen.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnderwaterMaterial {

    @SerializedName("Name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnderwaterMaterial() {
    }

    /**
     * 
     * @param name
     */
    public UnderwaterMaterial(String name) {
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
