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
public class R37 extends Thread {
    int id;
    int velocitat;
    int abast;
    int distanciaRecorreguda;
    Radar_ZaslonM radar;

    
    
    public R37(int misilId, Radar_ZaslonM radar) {
        id = misilId;
        velocitat = 10;           
        abast = 60;
        distanciaRecorreguda = 0;
        this.radar = radar;
    }
    
    
    public void calcularDesplaçament(){
        distanciaRecorreguda = distanciaRecorreguda + velocitat;
    }
    
    
    public void run(){
        Integer posicioMissil = null;
        while(true){
            posicioMissil = radar.connectarseAlRadar(id);
            if(posicioMissil != -1)break;
            try {
                System.out.println(getName()+" No s'ha pogut conectar al radar (posicio = -1)");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(distanciaRecorreguda < abast){
            calcularDesplaçament();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        radar.setObjectivoAlcanzado(id);
        radar.setEnemicsStatus();
        radar.desconnectarseDelRadar(posicioMissil,getName());

    }
    
    
    
}
