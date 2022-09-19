package no.gnome.asteroids.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Asteroid {

    @JsonProperty("absolute_magnitude_h")
    private Float absoluteMagnitudeH;

    @JsonProperty("close_approach_data")
    private CloseApproachData[] closeApproachData;

    @JsonProperty("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;

    private String id;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    @JsonProperty("is_sentry_object")
    private boolean isSentryObject;

    private Links links;

    private String name;

    @JsonProperty("nasa_jpl_url")
    private String nasaJplUrl;

    @JsonProperty("neo_reference_id")
    private String neoReferenceId;

    public Float getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(Float absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public CloseApproachData[] getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(CloseApproachData[] closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(EstimatedDiameter estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setPotentiallyHazardousAsteroid(boolean potentiallyHazardousAsteroid) {
        isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public boolean isSentryObject() {
        return isSentryObject;
    }

    public void setSentryObject(boolean sentryObject) {
        isSentryObject = sentryObject;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "absoluteMagnitudeH=" + absoluteMagnitudeH +
                ", closeApproachData=" + Arrays.toString(closeApproachData) +
                ", estimatedDiameter=" + estimatedDiameter +
                ", id='" + id + '\'' +
                ", isPotentiallyHazardousAsteroid=" + isPotentiallyHazardousAsteroid +
                ", isSentryObject=" + isSentryObject +
                ", links=" + links +
                ", name='" + name + '\'' +
                ", nasaJplUrl='" + nasaJplUrl + '\'' +
                ", neoReferenceId='" + neoReferenceId + '\'' +
                '}';
    }
}
