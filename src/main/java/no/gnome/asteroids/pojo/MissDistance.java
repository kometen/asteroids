package no.gnome.asteroids.pojo;

public class MissDistance {

    private String astronomical;
    private String kilometers;
    private String lunar;
    private String miles;

    public String getAstronomical() {
        return astronomical;
    }

    public void setAstronomical(String astronomical) {
        this.astronomical = astronomical;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "MissDistance{" +
                "astronomical='" + astronomical + '\'' +
                ", kilometers='" + kilometers + '\'' +
                ", lunar='" + lunar + '\'' +
                ", miles='" + miles + '\'' +
                '}';
    }
}
