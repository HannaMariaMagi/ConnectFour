import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Peaklass {
    public static void main(String[] args) {
        //mängu selgitav tekst
        System.out.println("Tere tulemast mängima mängu 'Connect Four'! ");
        System.out.println("Oma käigu ajal pead valima, millisest veerust oma nuppu soovid sisestada. Seejärel teeb seda sama sinu vastaseks olev arvuti.");
        System.out.println("Mängu eesmärgiks on olla esimene, kes moodustab horisontaalse, vertikaalse või diagonaalse joone neljast oma nupust.");
        System.out.println("Alustamiseks pead sisestama oma nime ja sümboli, millega sooviksid mängida." +
                " Seejärel sisesta soovitud mängulaua suurused ja võidu tingimus.");
        System.out.println("Head mängimist!");

        //kasutajaga suhtlemine
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisestage oma nimi: ");
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

        //mängimine
        while((laud.kontrolliVoit(inimene.getNupp()) != true) && (laud.kontrolliVoit(arvuti.getNupp()) != true)){
            System.out.println();
            System.out.println("Sisestage veerg, kuhu soovite nuppu panna: ");
            int sisestaVeergu = scanner.nextInt();
            laud.lisaNupp(sisestaVeergu, inimene.getNupp());
            System.out.println();
            System.out.println("Arvuti käik");
            int suvalineVeerg = ThreadLocalRandom.current().nextInt(1,ridadeArv+1);
            laud.lisaNupp(suvalineVeerg, arvuti.getNupp());
            laud.valjastaMangulaud();
            System.out.println();
            if (laud.kontrolliViik() == true){
                System.out.println("Mäng jäi viiki!");
                break;
            }
        }
        if((laud.kontrolliVoit(inimene.getNupp())) == true){
            System.out.println("Palju õnne " + mangijaNimi + "! Sina võitsid!");
        }
        else if ((laud.kontrolliVoit(arvuti.getNupp())) == true){
            System.out.println("Arvuti võitis!");
        }
        System.out.println("Mäng läbi");
    }
}
