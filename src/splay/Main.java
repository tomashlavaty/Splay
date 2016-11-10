/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splay;

import core.Kniha;
import core.Pobocka;
import core.Citatel;
import core.KnihaNazov;
import core.Vypozicka;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tomas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Splay strom = new Splay();
          strom.delete(new Node(new Auto(300)));
        Random rd = new Random();

        int[] test = new int[]{5};//53,73,13,65,80      
        //int[] test= new int[]{80,13,53,61,73,65,48,56,72,91,89,55,14,81,54};
        // int[] test= new int[]{10,8,9};

        for (int i = 0; i < test.length; i++) {
            strom.add(new Node(new Auto(test[i])));
            //strom.search(8).s}
        }
        strom.delete(new Node(new Auto(5)));
         System.out.println("obsah stromu"+strom.InOrderPrint());
         System.out.println(strom.getRoot());
        //strom.add(new Node(new Auto(54)));
      
//        System.out.println("Vysl.hladania " + strom.search(new Node(new Auto(12))));
        strom.delete(new Node(new Auto(6)));

        System.out.println(strom.levelOrder());
        Generator gen = new Generator();
       
       Kniha[] knihyPom= gen.generKnihy(5);
        for (Kniha k : knihyPom) {
             //System.out.println("K  "+k);
        }        
       
     
        Calendar calendar = new GregorianCalendar(2017, 10,20);
        Calendar calendar2 = new GregorianCalendar(2016, 10, 9);
       // calendar.add(calendar.DATE, 30);//pripocitanie dna
        System.out.println(calendar.compareTo(calendar2));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(calendar.getTime())); //15/10/2013
        System.out.println( TimeUnit.MILLISECONDS.toDays(Math.abs(calendar.getTimeInMillis()- calendar2.getTimeInMillis() )));
              
     
       
       
     
        InformacnySystem inf=new InformacnySystem();
        inf.naplnSystem();
        
       // inf.getCitatel("12539").setVypozicky(pobocky);
        inf.pridajPobocku("Detska");
        Pobocka pomPob = inf.najdiPobocku("Detska");
        
        inf.pridajKnihu(7, "Harry Poter","Rowling", "8181171", "656565", "roman", "Detska");
         inf.pridajKnihu(6, "Angry man ","Rowling", "8181171", "656565", "roman", "Detska");
//        System.out.println("Knihy\n"+inf.najdiPobocku("Zilinska").getKnihy().InOrderPrint());
        //System.out.println("Uzivateloa\n"+inf.getCitatelia().InOrderPrint());
        //System.out.println(inf.najdiKnihu(7, "Detska"));
        System.out.println("Pobocky\n"+inf.getPobocky().InOrderPrint());
       
         System.out.println("Citatelia\n"+inf.getCitatelia().InOrderPrint());
//          inf.pozicajKnihu(7, "12539", "Detska");
        //System.out.println("Hladanie citatela\n "+inf.getCitatel("12539").getVypozicky().InOrderPrint());
       // System.out.println(inf.najdiKnihu(7, "Detska").udaje());
        //System.out.println(inf.getCitatel("12539").getVypozicky().InOrderPrint());
        //Vypozicka v=new Vypozicka(knihyPom[0],10,1,2016);
        //System.out.println(v.getKniha().toString());
       
       
        
    }
}
