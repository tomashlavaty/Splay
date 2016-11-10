/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import splay.Node;
import splay.Splay;

/**
 *
 * @author tomas
 */
public class Pobocka implements IData{
    private String nazov; //sluzi ako identifikator
    private Splay knihy; 
    private Splay knihyNazvov; 
   // private Kniha kniha;

    public Pobocka(String nazov) {
        this.nazov = nazov;
        this.knihy=new Splay();
        this.knihyNazvov=new Splay();
    }
   
    public void pridajKnihu(Kniha k){
        //Kniha k=new Kniha(paId, paNazov, paAutor, paISBN, paEAN, paZaner, this);        
        k.setPriradenaPobocka(this);
       
        this.knihy.add(new Node(k));
        this.knihyNazvov.add(new Node(new KnihaNazov(k)));  
        //System.out.println("Pobocka: Pridana kniha "+k);
    }
    
    public Kniha najdiKnihu(int idKnihy){
        Kniha k=new Kniha(idKnihy);
        Node paNode=knihy.search(new Node(k));
        
        if(paNode!=null){
             return (Kniha)paNode.getData();
        }
        return null;       
    }     
    
    

    @Override
    public int compare(Node paNode) {
        String nazov = ((Pobocka) paNode.getData()).nazov;
        if (nazov.compareToIgnoreCase(this.nazov) < 0) {
            return -1;
        } else if (nazov.compareToIgnoreCase(this.nazov) > 0) {
            return 1;
        }
        else{
        return 0;
        }
    }

    public Splay getKnihy() {
        return knihy;
    }

    public Splay getKnihyNazvov() {
        return knihyNazvov;
    }

    public String getNazov() {
        return nazov;
    }       
    
    
    

    @Override
    public String toString() {
        return  nazov + ", knihy=" + knihy;
    }

    public void setKnihy(Splay knihy) {
        this.knihy = knihy;
    }
    
    
    
    
    
}
