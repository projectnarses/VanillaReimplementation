
package net.minestom.vanilla.generation.biome.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spawners {

    @SerializedName("monster")
    @Expose
    private List<Monster> monster = null;
    @SerializedName("creature")
    @Expose
    private List<Object> creature = null;
    @SerializedName("ambient")
    @Expose
    private List<Ambient> ambient = null;
    @SerializedName("water_creature")
    @Expose
    private List<Object> waterCreature = null;
    @SerializedName("water_ambient")
    @Expose
    private List<Object> waterAmbient = null;
    @SerializedName("misc")
    @Expose
    private List<Object> misc = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Spawners() {
    }

    /**
     * 
     * @param waterCreature
     * @param waterAmbient
     * @param ambient
     * @param creature
     * @param monster
     * @param misc
     */
    public Spawners(List<Monster> monster, List<Object> creature, List<Ambient> ambient, List<Object> waterCreature, List<Object> waterAmbient, List<Object> misc) {
        super();
        this.monster = monster;
        this.creature = creature;
        this.ambient = ambient;
        this.waterCreature = waterCreature;
        this.waterAmbient = waterAmbient;
        this.misc = misc;
    }

    public List<Monster> getMonster() {
        return monster;
    }

    public void setMonster(List<Monster> monster) {
        this.monster = monster;
    }

    public Spawners withMonster(List<Monster> monster) {
        this.monster = monster;
        return this;
    }

    public List<Object> getCreature() {
        return creature;
    }

    public void setCreature(List<Object> creature) {
        this.creature = creature;
    }

    public Spawners withCreature(List<Object> creature) {
        this.creature = creature;
        return this;
    }

    public List<Ambient> getAmbient() {
        return ambient;
    }

    public void setAmbient(List<Ambient> ambient) {
        this.ambient = ambient;
    }

    public Spawners withAmbient(List<Ambient> ambient) {
        this.ambient = ambient;
        return this;
    }

    public List<Object> getWaterCreature() {
        return waterCreature;
    }

    public void setWaterCreature(List<Object> waterCreature) {
        this.waterCreature = waterCreature;
    }

    public Spawners withWaterCreature(List<Object> waterCreature) {
        this.waterCreature = waterCreature;
        return this;
    }

    public List<Object> getWaterAmbient() {
        return waterAmbient;
    }

    public void setWaterAmbient(List<Object> waterAmbient) {
        this.waterAmbient = waterAmbient;
    }

    public Spawners withWaterAmbient(List<Object> waterAmbient) {
        this.waterAmbient = waterAmbient;
        return this;
    }

    public List<Object> getMisc() {
        return misc;
    }

    public void setMisc(List<Object> misc) {
        this.misc = misc;
    }

    public Spawners withMisc(List<Object> misc) {
        this.misc = misc;
        return this;
    }

}
