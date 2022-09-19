package no.gnome.asteroids.pojo;

public class ClosestAsteroids {

    private final int position;
    private final float distance;
    private final Asteroid asteroid;

    public ClosestAsteroids(int position, float distance, Asteroid asteroid) {
        this.position = position;
        this.distance = distance;
        this.asteroid = asteroid;
    }

    public int getPosition() {
        return position;
    }

    public float getDistance() {
        return distance;
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }
}
