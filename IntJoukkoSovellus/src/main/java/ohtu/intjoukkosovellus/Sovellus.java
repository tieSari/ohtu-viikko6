package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko joukkoA, joukkoB, joukkoC;

    private static String lueString() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko mikaJoukko() {
        String luettu = lueString();
        
        while (true) {
            if (luettu.equalsIgnoreCase("A")) {
                return joukkoA;
            }
            if (luettu.equalsIgnoreCase("B")) {
                return joukkoB;
            }
            if (luettu.equalsIgnoreCase("C")) {
                return joukkoC;
            }

            System.out.println("Virheellinen joukko! " + luettu);
            System.out.print("Yritä uudelleen!");
            luettu = lueString();
        }
    }

    private static void lisaa() {
        int lisLuku;
        IntJoukko joukko;

        joukko = KysyJoukko("");
        lisLuku = KysyLuku();

        joukko.lisaa(lisLuku);
    }

    private static IntJoukko KysyJoukko(String nro) {

        System.out.print("Anna joukko " + nro);
        return mikaJoukko();
    }

    private static int KysyLuku() {

        System.out.print("Anna luku ");
        Scanner lukija = new Scanner(System.in);
        return lukija.nextInt();
    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, yhdiste;

        aJoukko = KysyJoukko("1");
        bJoukko = KysyJoukko("2");

        yhdiste = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + yhdiste.toString());
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, leikkaus;

        aJoukko = KysyJoukko("1");
        bJoukko = KysyJoukko("2");

        leikkaus = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + leikkaus.toString());
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, erotus;

        aJoukko = KysyJoukko("1");
        bJoukko = KysyJoukko("2");

        erotus = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + erotus.toString());
    }

    private static void poista() {
        IntJoukko joukko;
        int poistettava;

        joukko = KysyJoukko("");
        poistettava = KysyLuku();

        joukko.poista(poistettava);
    }

    private static void kuuluu() {
        IntJoukko joukko;
        int kysLuku;

        joukko = KysyJoukko("");
        kysLuku = KysyLuku();

        boolean kuuluuko = joukko.kuuluuJoukkoon(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        joukkoA = new IntJoukko();
        joukkoB = new IntJoukko();
        joukkoC = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(joukkoA);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(joukkoB);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(joukkoC);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
