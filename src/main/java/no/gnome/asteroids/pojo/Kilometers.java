package no.gnome.asteroids.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kilometers {

    @JsonProperty("estimated_diameter_max")
    private float estimatedDiameterMax;

    @JsonProperty("estimated_diameter_min")
    private float estimatedDiameterMin;

    public float getEstimatedDiameterMax() {
        return estimatedDiameterMax;
    }

    public void setEstimatedDiameterMax(float estimatedDiameterMax) {
        this.estimatedDiameterMax = estimatedDiameterMax;
    }

    public float getEstimatedDiameterMin() {
        return estimatedDiameterMin;
    }

    public void setEstimatedDiameterMin(float estimatedDiameterMin) {
        this.estimatedDiameterMin = estimatedDiameterMin;
    }
}
