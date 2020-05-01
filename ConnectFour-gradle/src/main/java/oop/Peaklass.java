/*
package oop;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Peaklass {
    public static void main(String[] args) throws InterruptedException {
        //mängu selgitav tekst
        System.out.println("Tere tulemast mängima mängu 'Connect Four'! ");
        System.out.println("Oma käigu ajal pead valima, millisest veerust oma nuppu soovid sisestada. \nSeejärel teeb seda sama sinu vastaseks olev arvuti.");
        System.out.println("Mängu eesmärgiks on olla esimene, kes moodustab horisontaalse, vertikaalse või diagonaalse joone,\nmis oleks sama pikk kui võidu tingimus.");
        System.out.println("Alustamiseks pead sisestama oma nime ja sümboli, millega sooviksid mängida. \nSeejärel sisesta soovitud mängulaua suurused ja võidu tingimus.");
        System.out.println("Head mängimist!\n________________________________________________________________________");

        //kasutajaga suhtlemine
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSisestage oma nimi: ");
        String mangijaNimi = scanner.next();
        System.out.println("Sisestage sümbol, millega tahaksite mängida, näiteks '⚫': ");
        String mangijaNupp = scanner.next();
        System.out.println("Sisestage soovitud mängulaua ridade arv, tavamängus 6: ");
        int ridadeArv = scanner.nextInt();
        System.out.println("Sisestage soovitud mängulaua veergude arv, tavamängus 7: ");
        int veergudeArv = scanner.nextInt();
        System.out.println("Sisestage soovitud võidutingimus, tavamängus 4: ");
        int voiduTingimus = scanner.nextInt();

        //loome mängijad
        Mangija arvuti = new Mangija("Arvuti", "◙");
        Mangija inimene = new Mangija(mangijaNimi, mangijaNupp);

        //loome mängulaua
        Maatriks laud = new Maatriks(ridadeArv,veergudeArv, voiduTingimus);
        System.out.println("Loodud mängulaud: ");
        laud.looTuhiMangulaud();
        laud.valjastaMangulaud();

        //mängimine
        while(true){
            //inimene
            System.out.println("\nSisestage veerg, kuhu soovite nuppu panna: ");
            int sisestaVeergu = scanner.nextInt();
            laud.lisaNupp(sisestaVeergu, inimene.getNupp());
            laud.valjastaMangulaud();
            if (laud.kontrolliVoit(inimene.getNupp())) {
                System.out.println("\nPalju õnne " + mangijaNimi + "! Sina võitsid!");
                break;
            }
            if (laud.kontrolliViik()){
                System.out.println("\nMäng jäi viiki!");
                break;
            }

            //arvuti
            System.out.print("\n\nArvuti käik");
            for (int i = 0; i < 2; i++) {
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
            }

            int suvalineVeerg = ThreadLocalRandom.current().nextInt(1,ridadeArv+1);
            laud.lisaNupp(suvalineVeerg, arvuti.getNupp());
            laud.valjastaMangulaud();
            if (laud.kontrolliVoit(arvuti.getNupp())) {
                System.out.println("\nArvuti võitis!");
                break;
            }
            if (laud.kontrolliViik()){
                System.out.println("\nMäng jäi viiki!");
                break;
            }
        }
        System.out.println("Mäng läbi.");
    }
}*/