package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
            KOONLISAYS = 5;

    private int kasvu;
    private int[] joukko;
    private int alkioidenLkm;

    public IntJoukko() {
        joukko = new int[KAPASITEETTI];
        this.kasvu = KOONLISAYS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        joukko = new int[KAPASITEETTI];
        this.kasvu = KOONLISAYS;

    }

    public IntJoukko(int koko, int lisays) {
        if (koko < 0) {
            throw new IndexOutOfBoundsException("Koko ei voi olla negatiivinen");
        }
        if (lisays < 0) {
            throw new IndexOutOfBoundsException("lisäys ei voi olla negatiivinen");
        }
        joukko = new int[koko];
        this.kasvu = lisays;

    }

    public boolean lisaa(int luku) {

        int eiOle = 0;
        if (alkioidenLkm == 0) {
            joukko[0] = luku;
            alkioidenLkm++;
            return true;
        } else {
        }
        if (!kuuluuJoukkoon(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % joukko.length == 0) {
                int[] taulukkoOld = new int[joukko.length];
                taulukkoOld = joukko;
                kopioiTaulukko(joukko, taulukkoOld);
                joukko = new int[alkioidenLkm + kasvu];
                kopioiTaulukko(taulukkoOld, joukko);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                joukko[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = joukko[j];
                joukko[j] = joukko[j + 1];
                joukko[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int alkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {

        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + joukko[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += joukko[i];
                tuotos += ", ";
            }
            tuotos += joukko[alkioidenLkm - 1];
            tuotos += "}";

            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(i);
        }

        return erotus;
    }

}
