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
        laud.lisaNupp(2, arvuti.getNupp());
        laud.valjastaMangulaud();
        laud.lisaNupp(2, inimene.getNupp());
        laud.lisaNupp(3, arvuti.getNupp());
        laud.lisaNupp(3, arvuti.getNupp());
        laud.lisaNupp(3, inimene.getNupp());
        laud.lisaNupp(4, arvuti.getNupp());
        laud.lisaNupp(4, arvuti.getNupp());
        laud.lisaNupp(4, arvuti.getNupp());
        laud.lisaNupp(4, inimene.getNupp());
        laud.valjastaMangulaud();
        System.out.println(laud.kontrolliVoit(inimene.getNupp()));
    }
}
