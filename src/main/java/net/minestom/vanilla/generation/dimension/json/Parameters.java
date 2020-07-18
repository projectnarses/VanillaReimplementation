
package net.minestom.vanilla.generation.dimension.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

    @SerializedName("temperature")
    @Expose
    private double temperature;
    @SerializedName("humidity")
    @Expose
    private double humidity;
    @SerializedName("altitude")
    @Expose
    private double altitude;
    @SerializedName("weirdness")
    @Expose
    private double weirdness;
    @SerializedName("offset")
    @Expose
    private double offset;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Parameters() {
    }

    /**
     * 
     * @param altitude
     * @param offset
     * @param weirdness
     * @param temperature
     * @param humidity
     */
    public Parameters(double temperature, double humidity, double altitude, double weirdness, double offset) {
        super();
        this.temperature = temperature;
        this.humidity = humidity;
        this.altitude = altitude;
        this.weirdness = weirdness;
        this.offset = offset;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Parameters withTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Parameters withHumidity(double humidity) {
        this.humidity = humidity;
        return this;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public Parameters withAltitude(double altitude) {
        this.altitude = altitude;
        return this;
    }

    public double getWeirdness() {
        return weirdness;
    }

    public void setWeirdness(double weirdness) {
        this.weirdness = weirdness;
    }

    public Parameters withWeirdness(double weirdness) {
        this.weirdness = weirdness;
        return this;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public Parameters withOffset(double offset) {
        this.offset = offset;
        return this;
    }

}
