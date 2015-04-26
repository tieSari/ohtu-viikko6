package com.mycompany.webkauppa;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.ToimitusjarjestelmaFasaadi;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TyhjennaOstoskoriServlet extends WebKauppaServlet {

    public TyhjennaOstoskoriServlet(Varasto varasto, TuoteDAO tuote, PankkiFasaadi pankki, ToimitusjarjestelmaFasaadi toimitusjarjestelma) {
        super(varasto, tuote, pankki, toimitusjarjestelma);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Ostoskori ostoskori = haeSessionOstoskori(request);     
        ostoskori.tyhjenna();               

        naytaSivu("/Tuotelista", request, response);
    }
}
