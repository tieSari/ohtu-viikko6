
package com.mycompany.webkauppa;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import com.mycompany.webkauppa.ohjaus.Suoritus;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.ToimitusjarjestelmaFasaadi;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LisaaOstoskoriinServlet extends WebKauppaServlet {

    public LisaaOstoskoriinServlet(Varasto varasto, TuoteDAO tuote, PankkiFasaadi pankki, ToimitusjarjestelmaFasaadi toimitusjarjestelma) {
        super(varasto, tuote, pankki, toimitusjarjestelma);
    }

    

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
                        
        Suoritus lisays = suoritukset.OstoksenLisays(haeSessionOstoskori(request), tuoteId,varasto);
        lisays.suorita();
        
        naytaSivu("/Tuotelista", request, response);   
    }
}
