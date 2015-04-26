package com.mycompany.webkauppa;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.ToimitusjarjestelmaFasaadi;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TuotelistaServlet extends WebKauppaServlet {

    public TuotelistaServlet(Varasto varasto, TuoteDAO tuote, PankkiFasaadi pankki, ToimitusjarjestelmaFasaadi toimitusjarjestelma) {
        super(varasto, tuote, pankki, toimitusjarjestelma);
    }
           
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        Ostoskori ostoskori = haeSessionOstoskori(request);
        
        request.setAttribute("korissa", ostoskori.tuotteitaKorissa() );
        request.setAttribute("hinta", ostoskori.hinta() );       
        request.setAttribute("tuotteet", varasto.tuotteidenLista() );
        
        naytaSivu("/tuotelista.jsp", request, response);        
    }
}
