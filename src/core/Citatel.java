/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import splay.Generator;
import splay.Node;
import splay.Splay;

/**
 *
 * @author tomas
 */
public class Citatel implements IData {

    private String meno;
    private String priezvisko;
    private String cisloPreukazu;
    private Calendar zablokovanyDo;
    private  static SimpleDateFormat sdf=new SimpleDateFormat("dd/M/yyyy");
    
    private Splay vypozicky;
    private static  Generator gener=new Generator();

    public Citatel(String cisloPreukazu) {
        this.cisloPreukazu = cisloPreukazu;
        this.vypozicky=new Splay();
        
    } 
    

    public Citatel(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;       
        this.cisloPreukazu=gener.generZnaky(5);
        this.zablokovanyDo = new GregorianCalendar(2017, 10, 5);
        this.vypozicky=new Splay();
    }
   

    public String vypisZablokovanyDo() {
        String pom=(zablokovanyDo==null)?"neblokovany":sdf.format(zablokovanyDo.getTime());
        return pom;
    }

    @Override
    public int compare(Node paNode) {
        String cisloPreukazu = ((Citatel) paNode.getData()).cisloPreukazu;
        if (cisloPreukazu.compareToIgnoreCase(this.cisloPreukazu) < 0) {
            return -1;
        } else if (cisloPreukazu.compareToIgnoreCase(this.cisloPreukazu) > 0) {
            return 1;
        }
        else{
        return 0;
        }
    }

   
    
    
    public Splay getVypozicky() {
        return vypozicky;
    }

    public void setVypozicky(Splay vypozicky) {//na testovanie
        this.vypozicky = vypozicky;
    }  

    public String getMenoPriezvisko() {
        return meno+" "+priezvisko;
    }

    public Calendar getZablokovanyDo() {
        return zablokovanyDo;
    }   
       

    
     @Override
    public String toString() {        
        return meno + " " + priezvisko + " " + cisloPreukazu + " zablokovanyDo:" + this.vypisZablokovanyDo();
    }

}
