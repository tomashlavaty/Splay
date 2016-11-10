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
public class KnihaNazov implements IData {

    private Kniha kniha;
    
    public KnihaNazov(Kniha kniha) {
        this.kniha = kniha;
    }

    public Kniha getKniha() {
        return kniha;
    }

    @Override
    public int compare(Node paNode) {
        String nazov = ((KnihaNazov) paNode.getData()).getKniha().getNazov();
        if (nazov.compareTo(kniha.getNazov()) < 0) {
            return -1;
        } else if (nazov.compareTo(kniha.getNazov()) > 0) {
            return 1;
        }
        else{
        return 0;
        }       
       
    }

    

    @Override
    public String toString() {
        return  kniha.toString();
    }
    
    
    
   
   
}
