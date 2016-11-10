/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import splay.Node;

/**
 *
 * @author tomas
 */
public class Kniha implements IData {
    private static int counter=0;
    private int id;
    private String nazov;
    private String autor;
    private String ISBN;
    private String EAN;
    private String zaner;
    private Pobocka priradenaPobocka;
    private int poplatokOmeskania;
    private Vypozicka vypozicka;
    //private dobaVypozicky;
    

    public Kniha(int id) {
        this.id = id;
    }
    
    
    public Kniha( String nazov, String autor, String ISBN) {
        this.id = Kniha.counter;
        this.nazov = nazov;
        this.autor = autor;
        this.ISBN = ISBN;
        this.vypozicka=null;
        Kniha.counter+=1;
    }

    
     public Kniha(String nazov, String autor, String ISBN, String EAN, String zaner, Pobocka priradenaPobocka) {
        this.id = counter;
        this.nazov = nazov;
        this.autor = autor;
        this.ISBN = ISBN;
        this.EAN = EAN;
        this.zaner = zaner;
        this.priradenaPobocka = priradenaPobocka;
        this.poplatokOmeskania=4;
        this.vypozicka=null;
        Kniha.counter+=1;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNazov() {
        return nazov;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getEAN() {
        return EAN;
    }

    public Vypozicka getVypozicka() {
        return vypozicka;
    }

    public void setVypozicka(Vypozicka vypozicka) {
        this.vypozicka = vypozicka;
    }   
    

   
    
    @Override
    public int compare(Node paN) {
        int id = ((Kniha) paN.getData()).id;
        //int key = ((int) paKey) ;

        if (this.id > id) {
            return -1;
        } else if (this.id < id) {
            return 1;
        } else {
            return 0;
        }
    }

    public Pobocka getPriradenaPobocka() {
        return priradenaPobocka;
    }

    public void setPriradenaPobocka(Pobocka priradenaPobocka) {
        this.priradenaPobocka = priradenaPobocka;
    }


 
    /*
    this.id = id;
        this.nazov = nazov;
        this.autor = autor;
        this.ISBN = ISBN;
        this.EAN = EAN;
        this.zaner = zaner;
        this.priradenaPobocka = priradenaPobocka;
        this.poplatokOmeskania=4;*/
     @Override     
    public String toString() {
        return nazov+" "+id;
    }
    
        
    public String udaje() {
        String pom=(vypozicka==null)?"Volna":vypozicka.getCitatel().getMenoPriezvisko();
        return "Nazov: " + nazov + "\nAutor: " + autor +"\nŽáner: "+zaner+"\nISBN: " + ISBN + "\nEAN: " + 
                EAN +"\nPobočka: "+priradenaPobocka.getNazov()+"\nID:"+id +"\nPoplatok:"+poplatokOmeskania+"\n"+"Ma pozicane: "+pom;
    }
    
    
     /*
    @Override
    public String toString() {
        return "Kniha " + "id:" + id;
    }
*/
}
