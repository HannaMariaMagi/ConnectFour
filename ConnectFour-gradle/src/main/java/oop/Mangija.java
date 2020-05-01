package oop;

public class Mangija {
    private String nimi;
    private String varv;

    public Mangija(String nimi, String varv) {
        this.nimi = nimi;
        this.varv = varv;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setVarv(String nupp) {
        this.varv = varv;
    }

    public String getNimi() {
        return nimi;
    }

    public String getVarv() {
        return varv;
    }
}