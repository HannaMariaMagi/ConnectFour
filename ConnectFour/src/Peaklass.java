public class Peaklass {
    public static void main(String[] args) {
        //loome mängijad
        Mangija arvuti = new Mangija("Arvuti", "◙");
        Mangija inimene = new Mangija("Nonna", "⚫");
        //loome mängulaua
        Maatriks laud = new Maatriks(6,7);
        laud.looTuhiMangulaud();

        //mäng käib
        laud.lisaNupp(1, inimene.getNupp());
        laud.valjastaMangulaud();
        laud.lisaNupp(1, arvuti.getNupp());
        laud.valjastaMangulaud();
    }
}
