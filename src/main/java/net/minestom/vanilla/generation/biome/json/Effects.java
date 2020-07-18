
package net.minestom.vanilla.generation.biome.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Effects {

    @SerializedName("mood_sound")
    @Expose
    private MoodSound moodSound;
    @SerializedName("fog_color")
    @Expose
    private int fogColor;
    @SerializedName("water_color")
    @Expose
    private int waterColor;
    @SerializedName("water_fog_color")
    @Expose
    private int waterFogColor;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Effects() {
    }

    /**
     * 
     * @param waterColor
     * @param waterFogColor
     * @param fogColor
     * @param moodSound
     */
    public Effects(MoodSound moodSound, int fogColor, int waterColor, int waterFogColor) {
        super();
        this.moodSound = moodSound;
        this.fogColor = fogColor;
        this.waterColor = waterColor;
        this.waterFogColor = waterFogColor;
    }

    public MoodSound getMoodSound() {
        return moodSound;
    }

    public void setMoodSound(MoodSound moodSound) {
        this.moodSound = moodSound;
    }

    public Effects withMoodSound(MoodSound moodSound) {
        this.moodSound = moodSound;
        return this;
    }

    public int getFogColor() {
        return fogColor;
    }

    public void setFogColor(int fogColor) {
        this.fogColor = fogColor;
    }

    public Effects withFogColor(int fogColor) {
        this.fogColor = fogColor;
        return this;
    }

    public int getWaterColor() {
        return waterColor;
    }

    public void setWaterColor(int waterColor) {
        this.waterColor = waterColor;
    }

    public Effects withWaterColor(int waterColor) {
        this.waterColor = waterColor;
        return this;
    }

    public int getWaterFogColor() {
        return waterFogColor;
    }

    public void setWaterFogColor(int waterFogColor) {
        this.waterFogColor = waterFogColor;
    }

    public Effects withWaterFogColor(int waterFogColor) {
        this.waterFogColor = waterFogColor;
        return this;
    }

}
