package no.gnome.asteroids.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CloseApproachData {

    @JsonProperty("close_approach_date")
    private LocalDate closeApproachDate;

    @JsonProperty("epoch_date_close_approach")
    private Long epochDateCloseApproach;

    @JsonProperty("miss_distance")
    private MissDistance missDistance;

    @JsonProperty("orbiting_body")
    private String orbitingBody;

    @JsonProperty("relative_velocity")
    private RelativeVelocity relativeVelocity;

    public LocalDate getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(LocalDate closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }
    public Long getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }

    public void setEpochDateCloseApproach(Long epochDateCloseApproach) {
        this.epochDateCloseApproach = epochDateCloseApproach;
    }

    public MissDistance getMissDistance() {
        return missDistance;
    }

    public void setMissDistance(MissDistance missDistance) {
        this.missDistance = missDistance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    public RelativeVelocity getRelativeVelocity() {
        return relativeVelocity;
    }

    public void setRelativeVelocity(RelativeVelocity relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    @Override
    public String toString() {
        return "CloseApproachData{" +
                "closeApproachDate=" + closeApproachDate +
                ", epochDateCloseApproach=" + epochDateCloseApproach +
                ", missDistance=" + missDistance +
                ", orbitingBody='" + orbitingBody + '\'' +
                ", relativeVelocity=" + relativeVelocity +
                '}';
    }
}
