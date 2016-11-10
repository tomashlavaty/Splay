/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splay;

import core.IData;

/** 
 * @author tomas
 */
public class Auto implements IData {

    private int VIN;
    private String nazov;

    public Auto(int VIN) {
        this.VIN = VIN;
    }

    public Auto(int VIN, String nazov) {
        this.VIN = VIN;
        this.nazov = nazov;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    
    public int compare(Node paNode) {
        int vin = ((Auto) paNode.getData()).VIN;
        if (this.VIN > vin) {
            return -1;
        } else if (this.VIN < vin) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "Auto:" + VIN;
    }

   

 

}
