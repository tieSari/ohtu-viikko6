/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    
    public Nollaa(Sovelluslogiikka sovellus,  JTextField tuloskentta,  JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        tuloskentta.setText(sovellus.tulos()+"");
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
