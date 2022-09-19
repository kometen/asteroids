package no.gnome.asteroids.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelativeVelocity {

    @JsonProperty("kilometers_per_hour")
    private String kilometersPerHour;

    @JsonProperty("kilometers_per_second")
    private String kilometersPerSecond;

    @JsonProperty("miles_per_hour")
    private String milesPerHour;

    public String getKilometersPerHour() {
        return kilometersPerHour;
    }

    public void setKilometersPerHour(String kilometersPerHour) {
        this.kilometersPerHour = kilometersPerHour;
    }

    public String getKilometersPerSecond() {
        return kilometersPerSecond;
    }

    public void setKilometersPerSecond(String kilometersPerSecond) {
        this.kilometersPerSecond = kilometersPerSecond;
    }

    public String getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(String milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    @Override
    public String toString() {
        return "RelativeVelocity{" +
                "kilometersPerHour='" + kilometersPerHour + '\'' +
                ", kilometersPerSecond='" + kilometersPerSecond + '\'' +
                ", milesPerHour='" + milesPerHour + '\'' +
                '}';
    }
}
