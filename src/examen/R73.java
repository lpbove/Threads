/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gines
 */
public class R73 extends Thread {
    int id;
    int velocitat;
    int abast;
    int distanciaRecorreguda;
    GuiaInfrarroja_IRST IRST;

    
    
    public R73(int id, GuiaInfrarroja_IRST IRST) {
        this.id = id;
        velocitat = 10;           
        abast = 30;
        distanciaRecorreguda = 0;
        this.IRST = IRST;
    }
    
    
    public void calcularDesplazamiento(){
        distanciaRecorreguda = distanciaRecorreguda + velocitat;
    }
    
    
    public void run(){
    }
    
    
}
