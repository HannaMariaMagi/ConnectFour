package oop;

import java.util.ArrayList;

public class Maatriks {
    private int ridade_arv;
    private int veergude_arv;
    private int voidu_tingimus;
    private ArrayList<ArrayList<String>> mangulaud;
    private String tuhi_nupp = "⚪";

    public Maatriks(int ridade_arv, int veergude_arv, int voidu_tingimus) {
        this.ridade_arv = ridade_arv;
        this.veergude_arv = veergude_arv;
        this.voidu_tingimus = voidu_tingimus;
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
        setMangulaud(maatriks);
    }

    public void lisaNupp(int veerg, String nupp) {
        veerg -= 1;
        if (mangulaud.get(0).get(veerg).equals(tuhi_nupp)) {
            for (int i = ridade_arv - 1; i >= 0; i--) {
                if (mangulaud.get(i).get(veerg).equals(tuhi_nupp)) {
                    mangulaud.get(i).set(veerg, nupp);
                    break;
                }
            }
        } else {
            System.out.println("Veerg on nuppe täis.");
        }
    }

    public void valjastaMangulaud() {
        for (ArrayList<String> rida : mangulaud) {
            System.out.println();
            for (int i = 0; i < rida.size(); i++) {
                System.out.print(rida.get(i) + "\t");
            }
        }
        System.out.println();
        for (int i = 1; i <= veergude_arv; i++) {
            System.out.print(i + "\t");
        }
    }

    public boolean kontrolliVoit(String nupp) {
        //ridu
        ridadeforloop:
        for (int i = ridade_arv - 1; i >= 0; i--) {
            int jarjest_nuppe = 0;
            int jarjest_tuhje = 0;
            for (int j = 0; j < veergude_arv; j++) {
                if (mangulaud.get(i).get(j).equals(nupp)) {
                    jarjest_nuppe += 1;
                    if (jarjest_nuppe == voidu_tingimus) {
                        return true;
                    }
                }
                if (!mangulaud.get(i).get(j).equals(nupp)) {
                    jarjest_nuppe = 0;
                }
                if (mangulaud.get(i).get(j).equals(tuhi_nupp)) {
                    jarjest_tuhje += 1;
                    if (jarjest_tuhje == veergude_arv) {
                        break ridadeforloop;
                    }
                }
            }
        }

        //veerge
        for (int i = veergude_arv - 1; i >= 0; i--) {
            int jarjest_nuppe = 0;
            for (int j = ridade_arv - 1; j >= 0; j--) {
                if (mangulaud.get(j).get(i).equals(tuhi_nupp)) {
                    break;
                }
                if (mangulaud.get(j).get(i).equals(nupp)) {
                    jarjest_nuppe += 1;
                    if (jarjest_nuppe == voidu_tingimus) {
                        return true;
                    }
                }
                if (!mangulaud.get(j).get(i).equals(nupp)) {
                    jarjest_nuppe = 0;
                }
            }
        }

        //diagonaale
        for (int i = ridade_arv - 1; i >= 0; i--) {
            for (int j = 0; j < veergude_arv; j++) {
                if (mangulaud.get(i).get(j).equals(nupp)) {
                    //kontrollib "/" pidi
                    if (j <= veergude_arv - voidu_tingimus && i >= voidu_tingimus - 1) {
                        if (mangulaud.get(i - 1).get(j + 1).equals(nupp) &&
                                mangulaud.get(i - 2).get(j + 2).equals(nupp) &&
                                mangulaud.get(i - 3).get(j + 3).equals(nupp)) {
                            return true;
                        }
                    }
                    // kontrollib "\" pidi
                    if (j >= voidu_tingimus - 1 && i >= voidu_tingimus - 1) {
                        if (mangulaud.get(i - 1).get(j - 1).equals(nupp) &&
                                mangulaud.get(i - 2).get(j - 2).equals(nupp) &&
                                mangulaud.get(i - 3).get(j - 3).equals(nupp)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean kontrolliViik(){
        for (int i = 0; i < veergude_arv; i++) {
            if (mangulaud.get(0).get(i).equals(tuhi_nupp)) {
                return false;
            }
        }
        return true;
    }

    public int getRidade_arv() {
        return ridade_arv;
    }

    public int getVeergude_arv() {
        return veergude_arv;
    }
}
