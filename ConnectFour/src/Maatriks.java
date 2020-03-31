import java.util.ArrayList;

public class Maatriks {
    private int ridade_arv;
    private int veergude_arv;
    private ArrayList<ArrayList<String>> mangulaud;
    private String tuhi_nupp = "⚪";

    public Maatriks(int ridade_arv, int veergude_arv) {
        this.ridade_arv = ridade_arv;
        this.veergude_arv = veergude_arv;
    }

    public void setMangulaud(ArrayList<ArrayList<String>> mangulaud) {
        this.mangulaud = mangulaud;
    }

    public void looTuhiMangulaud() {
        ArrayList<ArrayList<String>> maatriks = new ArrayList<>(ridade_arv);
        for (int i = 0; i < ridade_arv; i++) {
            maatriks.add(new ArrayList());
            for (int j = 0; j < veergude_arv; j++) {
                maatriks.get(i).add(tuhi_nupp);
            }
        }
        for (ArrayList<String> maatrik : maatriks) {
            System.out.println(maatrik);
        }
        setMangulaud(maatriks);
    }

    public void lisaNupp(int veerg, String nupp) {
        veerg -= 1;
        if (mangulaud.get(0).get(veerg).equals(tuhi_nupp)){
            for (int i = mangulaud.size() - 1; i >= 1; i--) {
                if (mangulaud.get(i).get(veerg).equals(tuhi_nupp)) {
                    mangulaud.get(i).set(veerg, nupp);
                    break;
                }
            }
        }
        else {
            System.out.println("Veerg on nuppe täis.");
        }

    }
    public void valjastaMangulaud() {
        for (ArrayList<String> rida : mangulaud) {
            System.out.println(rida);
        }
    }



   // ⚫ ⚪ 🅐
}