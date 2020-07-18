
package net.minestom.vanilla.generation.biome.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoodSound {

    @SerializedName("sound")
    @Expose
    private String sound;
    @SerializedName("tick_delay")
    @Expose
    private int tickDelay;
    @SerializedName("block_search_extent")
    @Expose
    private int blockSearchExtent;
    @SerializedName("offset")
    @Expose
    private double offset;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MoodSound() {
    }

    /**
     * 
     * @param offset
     * @param sound
     * @param blockSearchExtent
     * @param tickDelay
     */
    public MoodSound(String sound, int tickDelay, int blockSearchExtent, double offset) {
        super();
        this.sound = sound;
        this.tickDelay = tickDelay;
        this.blockSearchExtent = blockSearchExtent;
        this.offset = offset;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public MoodSound withSound(String sound) {
        this.sound = sound;
        return this;
    }

    public int getTickDelay() {
        return tickDelay;
    }

    public void setTickDelay(int tickDelay) {
        this.tickDelay = tickDelay;
    }

    public MoodSound withTickDelay(int tickDelay) {
        this.tickDelay = tickDelay;
        return this;
    }

    public int getBlockSearchExtent() {
        return blockSearchExtent;
    }

    public void setBlockSearchExtent(int blockSearchExtent) {
        this.blockSearchExtent = blockSearchExtent;
    }

    public MoodSound withBlockSearchExtent(int blockSearchExtent) {
        this.blockSearchExtent = blockSearchExtent;
        return this;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public MoodSound withOffset(double offset) {
        this.offset = offset;
        return this;
    }

}
