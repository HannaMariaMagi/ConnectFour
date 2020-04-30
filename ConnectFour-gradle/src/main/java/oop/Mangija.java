package oop;

public class Mangija {
    private String nimi;
    private String nupp;

    public Mangija(String nimi, String nupp) {
        this.nimi = nimi;
        this.nupp = nupp;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setNupp(String nupp) {
        this.nupp = nupp;
    }

    public String getNimi() {
        return nimi;
    }

    public String getNupp() {
        return nupp;
    }
}