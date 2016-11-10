/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splay;

import core.Citatel;
import core.Kniha;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class Generator {

    private static final String pismena = ("abcdefghijklmnopqrstuvwxyz");
    private static final String znaky = ("abcdefghijklmnopqrstuvwxyz1234567890");

    private HashMap<Integer, String> mena;
    private HashMap<Integer, String> priezviska;
    private HashMap<Integer, String> knihy;
    private HashMap<Integer, String> zanre;
    private ArrayList<Integer> IdSet;
    private Random rd;
    private Kniha kniha;

    public Generator() {
        rd = new Random();

        this.mena = new HashMap<Integer, String>();
        this.priezviska = new HashMap<Integer, String>();
        this.knihy = new HashMap<Integer, String>();
        this.zanre = new HashMap<Integer, String>();
        nacitajData(priezviska, "data\\priezviskaEN.txt");
        nacitajData(mena, "data\\mena.txt");
        nacitajData(knihy, "data\\knihyEN.txt");
        nacitajData(zanre, "data\\zanreEN.txt");
    }

    public long generCislo(int dlzka) {
        String retaz = "";
        for (int i = 0; i < dlzka; i++) {
            retaz += rd.nextInt(10) + "";
        }
        return Long.parseLong(retaz);
    }

    public String generSlovo(int dlzka) {

        String retaz = "";
        for (int i = 0; i < dlzka; i++) {
            retaz += pismena.charAt(rd.nextInt(pismena.length()));
        }
        return retaz;
    }

    public String generZnaky(int dlzka) {
        String retaz = "";
        for (int i = 0; i < dlzka; i++) {
            retaz += znaky.charAt(rd.nextInt(znaky.length()));
        }
        return retaz;

    }

    public String generISBN() {
        return "978-" + generCislo(rd.nextInt(3) + 1) + "-" + generCislo(rd.nextInt(5) + 2) + "-" + generCislo(rd.nextInt(6) + 1);
    }

    public String generEAN() {  //https://en.wikipedia.org/wiki/International_Article_Number
        String ean = "";
        int checkSum = 0;
        byte prvok;
        for (int i = 12; i > 0; i--) {
            prvok = (byte) generCislo(1);
            checkSum += (i % 2 == 0) ? prvok : prvok * 3;
            ean += prvok + "";
        }
        checkSum = (((checkSum / 10) + 1) * 10) - checkSum;
       
        return (ean + checkSum);
    }

    public Kniha[] generKnihy(int pocet) {
        Kniha[] knihy = new Kniha[pocet];
        String nazov;
        String autor;
        String ISBN;
        // this.generator(pocet);
        //int i=0;
        for (int i = 0; i < pocet; i++) {
            nazov = this.knihy.get(rd.nextInt(this.knihy.size()));// generSlovo(rd.nextInt(6)+4);
            autor = mena.get(rd.nextInt(mena.size())) + " " + priezviska.get(rd.nextInt(priezviska.size()));
            ISBN = generISBN();
            knihy[i] = new Kniha(nazov, autor, ISBN);
        }
        return knihy;
    }

    public Kniha generujKnihu() {
        Kniha novaKniha;
        String nazov = this.knihy.get(rd.nextInt(this.knihy.size()));
        String autor = mena.get(rd.nextInt(mena.size())) + " " + priezviska.get(rd.nextInt(priezviska.size()));
        String zaner = this.zanre.get(rd.nextInt(this.knihy.size()));
        String ISBN = this.generISBN();
        String EAN = this.generEAN();

        novaKniha = new Kniha(nazov, autor, ISBN, EAN, zaner, null);
        return novaKniha;
    }
    
   /* public Citatel generujCitatela(){
        Citatel novyCitatel;
        novyCitatel=new Citatel(pismena, pismena)
    
    }*/

    public static void nacitajData(HashMap<Integer, String> hashmap, String path) {
        int i = 0;
        try {
            File f = new File(path);
            Scanner sc = new Scanner(new FileReader(f));
            while (sc.hasNext()) {
                String zaznam = sc.nextLine();
                hashmap.put(i, zaznam);
                i++;
            }
        } catch (Exception e) {
        }

    }

    public void generator(int size) {
        //this.size = size;
        IdSet = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            IdSet.add(new Integer(i));
        }
        Collections.shuffle(IdSet);
    }

    public int randomPick() {

        int indexPick = rd.nextInt(IdSet.size());
        int value = IdSet.get(indexPick);
        IdSet.remove(indexPick);

        return value;
    }

    public String randomMeno() {
        return this.mena.get(rd.nextInt(mena.size()));
    }

    public String randomPriezvisko() {
        return this.priezviska.get(rd.nextInt(priezviska.size()));
    }

    public HashMap<Integer, String> getMena() {
        return mena;
    }

    public HashMap<Integer, String> getPriezviska() {
        return priezviska;
    }

    public HashMap<Integer, String> getKnihy() {
        return knihy;
    }

    public ArrayList<Integer> getIdSet() {
        return IdSet;
    }

}
