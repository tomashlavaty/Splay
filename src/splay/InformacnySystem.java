/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splay;

import core.Citatel;
import core.Kniha;
import core.Pobocka;
import core.Vypozicka;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author tomas
 */
public class InformacnySystem {
    // private Kniha kniha;
    // private Vypozicka vypozicka;

    private Splay citatelia;
    private Splay pobocky;
    private Generator gener = new Generator();
    private Calendar aktualnyDatum = new GregorianCalendar();
    private  static SimpleDateFormat sdf=new SimpleDateFormat("dd/M/yyyy");

    public InformacnySystem() {
        this.citatelia = new Splay();
        this.pobocky = new Splay();

    }

    public Splay getCitatelia() {
        return citatelia;
    }

    public Splay getPobocky() {
        return pobocky;
    }

    public void pridajCitatela(String paMena, String paPriezvisko) {
        Citatel c = new Citatel(paMena, paPriezvisko);
        this.citatelia.add(new Node(c));
    }

    public void pridajKnihu(int paId, String paNazov, String paAutor, String paISBN, String paEAN, String paZaner, String paNazovPobocky) {
        Pobocka pomPob = (Pobocka) this.pobocky.search(new Node(new Pobocka(paNazovPobocky))).getData();
        Kniha k = new Kniha(paNazov, paAutor, paISBN, paEAN, paZaner, pomPob);
        pomPob.pridajKnihu(k);
        // pomPob.g
    }

    public void pridajPobocku(String paNazov) {
        this.pobocky.add(new Node(new Pobocka(paNazov)));
    }

    public void pridajPobocku(Pobocka paPobocka) {
        this.pobocky.add(new Node(paPobocka));
    }

    public Pobocka najdiPobocku(String paNazov) {

        if (!paNazov.equals("")) {
            Node pomN = this.pobocky.search(new Node(new Pobocka(paNazov)));
            return (Pobocka) pomN.getData();
        } else {
            System.out.println("Informacny system - pobocka sa nenasla");
        }
        return null;
    }

    public Kniha najdiKnihu(int idKnihy, String nazovPobocky) {
        Pobocka pomP = najdiPobocku(nazovPobocky);
        if (pomP != null) {
            return pomP.najdiKnihu(idKnihy);
        } else {
            System.out.println("Informacny system - Kniha alebo pobocka sa nenasla");
            return null;
        }
    }

    public void pozicajKnihu(int idKnihy, String cisloPreukazu, String nazovPobocky) {

        Citatel zaujemca = this.getCitatel(cisloPreukazu);
        if (zaujemca.getZablokovanyDo().compareTo(aktualnyDatum) >= 0) {
            System.out.println("IS: Nemozes si pozicat knihu, mas blokovany ucet");
        } else {
            Kniha pomKniha = this.najdiKnihu(idKnihy, nazovPobocky);
            Vypozicka vypozicka = new Vypozicka(pomKniha, zaujemca);
            zaujemca.getVypozicky().add(new Node(vypozicka));
            pomKniha.setVypozicka(vypozicka);
        }

    }
    
    public String vypisAktualntDatum(){
       return sdf.format(aktualnyDatum.getTime());       
    }

    public void setAktualnyDatum(int paDen,int paMesiac,int paRok) {
        this.aktualnyDatum =  new GregorianCalendar(paRok,paMesiac-1,paDen);         
    }
    
    

    public String getPozicaneKnihyUzivatela() {
        String knihy = "not implement yet";
        return knihy;
    }

    public Citatel getCitatel(String cisloPreukazu) {
        Citatel hladanyCitatel = new Citatel(cisloPreukazu);
        hladanyCitatel = (Citatel) citatelia.search(new Node(hladanyCitatel)).getData();
        return hladanyCitatel;
    }

    public boolean vymazCitatela(String cisoPreukazu) {
        Citatel naVymazanie = (Citatel) citatelia.search(new Node(new Citatel(cisoPreukazu))).getData();
        boolean vysledok = false;
        if (naVymazanie.getVypozicky().getRoot() == null) {
            System.out.println("OK nemas nic pozicane");
            vysledok = this.citatelia.delete(new Node(naVymazanie));
            if (vysledok) {
                System.out.println("IS: vymazanie prebehlo v poriadku");
            } else {
                System.out.println("IS: vymazanie neprebehlo(existuje taky uzivatel? )");
            }
        } else {
            System.out.println("prrr najpvr vrat knihy");
        }

        return vysledok;
    }

    public void naplnSystem() {
        int pocetPobociek = 5;
        int pocetCitatelov = 10;
        int pocetKnih = 5;
        //String[] nazvy={"Zilinska","Univerzitna","Krajska"};        
        //Splay pozicane = new Splay();
        //Kniha[] knihyPom = new Kniha[100];//= gen.generKnihy(10);

        for (int i = 0; i < pocetCitatelov; i++) {
            this.pridajCitatela(gener.randomMeno(), gener.randomPriezvisko());

        }

        Pobocka pomPob;
        for (int i = 0; i < pocetPobociek; i++) {
            pomPob = new Pobocka(gener.generSlovo(6));
            this.pridajPobocku(pomPob);

            for (int j = 0; j < pocetKnih; j++) {
                pomPob.pridajKnihu(gener.generujKnihu());
            }

        }

    }

}
