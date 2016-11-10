/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import splay.Node;

/**
 *
 * @author tomas
 */
public class Vypozicka implements IData{
    private Citatel citatel;
    private Kniha kniha;
    private Calendar datumPozicania;
    private Calendar datumVratenia;
    private  static SimpleDateFormat sdf=new SimpleDateFormat("dd/M/yyyy");

    public Vypozicka(Kniha kniha,Citatel citatel, int paDen,int paMesiac,int paRok) {
        this.kniha = kniha;
        this.datumPozicania = new GregorianCalendar(paRok, paMesiac-1, paDen);//POZOR na mesiac 0-Januar atd
        this.datumVratenia=null; //nieje vratena
        this.citatel=citatel;
    }
    
    public Vypozicka(Kniha kniha,Citatel citatel) {
        this.kniha = kniha;
        this.datumPozicania = new GregorianCalendar();
        this.datumVratenia=null; //nieje vratena
        this.citatel=citatel;
    }
    //SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
      //  System.out.println(sdf.format(calendar.getTime())); //15/10/2013
    public String vypisDatumPozicania(){
        return sdf.format(datumPozicania.getTime());
    }

    public Kniha getKniha() {
        return kniha;
    }

    public Calendar getDatumPozicania() {
        return datumPozicania;
    }

    public Calendar getDatumVratenia() {
        return datumVratenia;
    }

    public Citatel getCitatel() {
        return citatel;
    }
        
    
    @Override
    public String toString() {
        return kniha.toString() + "\nPozicane dna:" + sdf.format(datumPozicania.getTime()) ;
    }

   @Override
    public int compare(Node paN) {
        int id = ((Vypozicka) paN.getData()).getKniha().getId();
        //int key = ((int) paKey) ;

        if (this.getKniha().getId() > id) {
            return -1;
        } else if (this.getKniha().getId() < id) {
            return 1;
        } else {
            return 0;
        }
    }



   
    
    
    
    
}
