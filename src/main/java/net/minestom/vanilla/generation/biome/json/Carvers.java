
package net.minestom.vanilla.generation.biome.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carvers {

    @SerializedName("air")
    @Expose
    private List<String> air = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Carvers() {
    }

    /**
     * 
     * @param air
     */
    public Carvers(List<String> air) {
        super();
        this.air = air;
    }

    public List<String> getAir() {
        return air;
    }

    public void setAir(List<String> air) {
        this.air = air;
    }

    public Carvers withAir(List<String> air) {
        this.air = air;
        return this;
    }

}
