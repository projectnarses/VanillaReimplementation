
package net.minestom.vanilla.generation.worldgen.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("top_material")
    @Expose
    private TopMaterial topMaterial;
    @SerializedName("under_material")
    @Expose
    private UnderMaterial underMaterial;
    @SerializedName("underwater_material")
    @Expose
    private UnderwaterMaterial underwaterMaterial;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Config() {
    }

    /**
     * 
     * @param underMaterial
     * @param underwaterMaterial
     * @param topMaterial
     */
    public Config(TopMaterial topMaterial, UnderMaterial underMaterial, UnderwaterMaterial underwaterMaterial) {
        super();
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.underwaterMaterial = underwaterMaterial;
    }

    public TopMaterial getTopMaterial() {
        return topMaterial;
    }

    public void setTopMaterial(TopMaterial topMaterial) {
        this.topMaterial = topMaterial;
    }

    public UnderMaterial getUnderMaterial() {
        return underMaterial;
    }

    public void setUnderMaterial(UnderMaterial underMaterial) {
        this.underMaterial = underMaterial;
    }

    public UnderwaterMaterial getUnderwaterMaterial() {
        return underwaterMaterial;
    }

    public void setUnderwaterMaterial(UnderwaterMaterial underwaterMaterial) {
        this.underwaterMaterial = underwaterMaterial;
    }

}
