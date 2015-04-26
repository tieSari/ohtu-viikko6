
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

/**
 *
 * @author sariraut
 */
public class SuoritusTehdas {
    
    public static Suoritus OstoksenPoisto(Ostoskori ostoskori, long tuoteId, Varasto varasto)
    {
        return new OstoksenPoistoKorista(null, tuoteId, varasto);
    }
    
    public static Suoritus OstoksenLisays(Ostoskori ostoskori, long tuoteId, Varasto varasto)
    {
        return new OstoksenLisaysKoriin(ostoskori, tuoteId,varasto);
    }
    
    public static Suoritus OstoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori, Varasto varasto)
    {
        return new OstoksenSuoritus(nimi,osoite, luottokorttinumero, kori,varasto);
    }
    
}
