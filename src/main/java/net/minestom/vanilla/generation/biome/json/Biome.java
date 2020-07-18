
package net.minestom.vanilla.generation.biome.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Biome {

    @SerializedName("starts")
    @Expose
    private List<String> starts = null;
    @SerializedName("spawners")
    @Expose
    private Spawners spawners;
    @SerializedName("spawn_costs")
    @Expose
    private SpawnCosts spawnCosts;
    @SerializedName("sky_color")
    @Expose
    private int skyColor;
    @SerializedName("surface_builder")
    @Expose
    private String surfaceBuilder;
    @SerializedName("carvers")
    @Expose
    private Carvers carvers;
    @SerializedName("features")
    @Expose
    private List<List<Object>> features = null;
    @SerializedName("scale")
    @Expose
    private double scale;
    @SerializedName("temperature")
    @Expose
    private double temperature;
    @SerializedName("downfall")
    @Expose
    private double downfall;
    @SerializedName("effects")
    @Expose
    private Effects effects;
    @SerializedName("precipitation")
    @Expose
    private String precipitation;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("depth")
    @Expose
    private double depth;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Biome() {
    }

    /**
     * 
     * @param skyColor
     * @param carvers
     * @param scale
     * @param downfall
     * @param spawners
     * @param features
     * @param precipitation
     * @param surfaceBuilder
     * @param effects
     * @param depth
     * @param spawnCosts
     * @param temperature
     * @param starts
     * @param category
     */
    public Biome(List<String> starts, Spawners spawners, SpawnCosts spawnCosts, int skyColor, String surfaceBuilder, Carvers carvers, List<List<Object>> features, double scale, double temperature, double downfall, Effects effects, String precipitation, String category, double depth) {
        super();
        this.starts = starts;
        this.spawners = spawners;
        this.spawnCosts = spawnCosts;
        this.skyColor = skyColor;
        this.surfaceBuilder = surfaceBuilder;
        this.carvers = carvers;
        this.features = features;
        this.scale = scale;
        this.temperature = temperature;
        this.downfall = downfall;
        this.effects = effects;
        this.precipitation = precipitation;
        this.category = category;
        this.depth = depth;
    }

    public List<String> getStarts() {
        return starts;
    }

    public void setStarts(List<String> starts) {
        this.starts = starts;
    }

    public Biome withStarts(List<String> starts) {
        this.starts = starts;
        return this;
    }

    public Spawners getSpawners() {
        return spawners;
    }

    public void setSpawners(Spawners spawners) {
        this.spawners = spawners;
    }

    public Biome withSpawners(Spawners spawners) {
        this.spawners = spawners;
        return this;
    }

    public SpawnCosts getSpawnCosts() {
        return spawnCosts;
    }

    public void setSpawnCosts(SpawnCosts spawnCosts) {
        this.spawnCosts = spawnCosts;
    }

    public Biome withSpawnCosts(SpawnCosts spawnCosts) {
        this.spawnCosts = spawnCosts;
        return this;
    }

    public int getSkyColor() {
        return skyColor;
    }

    public void setSkyColor(int skyColor) {
        this.skyColor = skyColor;
    }

    public Biome withSkyColor(int skyColor) {
        this.skyColor = skyColor;
        return this;
    }

    public String getSurfaceBuilder() {
        return surfaceBuilder;
    }

    public void setSurfaceBuilder(String surfaceBuilder) {
        this.surfaceBuilder = surfaceBuilder;
    }

    public Biome withSurfaceBuilder(String surfaceBuilder) {
        this.surfaceBuilder = surfaceBuilder;
        return this;
    }

    public Carvers getCarvers() {
        return carvers;
    }

    public void setCarvers(Carvers carvers) {
        this.carvers = carvers;
    }

    public Biome withCarvers(Carvers carvers) {
        this.carvers = carvers;
        return this;
    }

    public List<List<Object>> getFeatures() {
        return features;
    }

    public void setFeatures(List<List<Object>> features) {
        this.features = features;
    }

    public Biome withFeatures(List<List<Object>> features) {
        this.features = features;
        return this;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public Biome withScale(double scale) {
        this.scale = scale;
        return this;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Biome withTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public double getDownfall() {
        return downfall;
    }

    public void setDownfall(double downfall) {
        this.downfall = downfall;
    }

    public Biome withDownfall(double downfall) {
        this.downfall = downfall;
        return this;
    }

    public Effects getEffects() {
        return effects;
    }

    public void setEffects(Effects effects) {
        this.effects = effects;
    }

    public Biome withEffects(Effects effects) {
        this.effects = effects;
        return this;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public Biome withPrecipitation(String precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Biome withCategory(String category) {
        this.category = category;
        return this;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public Biome withDepth(double depth) {
        this.depth = depth;
        return this;
    }

}
