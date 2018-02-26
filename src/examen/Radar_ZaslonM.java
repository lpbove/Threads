/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gines
 */

//El radar Zaslon-M controlarà als míssils R-37 (32 míssils, 32 fils por tant) però només pot guiar 4 míssils a la vegada.
//Aquesta classe actua de monitor dels R37.

public class Radar_ZaslonM  {
    private Integer[] controlMissils;                   //El radar pot controlar 4 míssils simultàneament, en cada posició de l'array hi haurà el ID del míssil que controla.
    private boolean[] controlDisponibilitatMissils;     //A TRUE si encara es pot afegir algun míssil al controlMissils (es poden guiar 4 míssils simultàneamente).
    ArrayList<Integer> objectivoAlcanzado = new ArrayList<Integer>();       //Anem fican els Id dels míssils que fassin impacte.
    ArrayList enemicsStatus = new ArrayList();
    private int enemicsAtacats = 0;

    
    public Radar_ZaslonM() {
        controlMissils = new Integer[]{-1, -1, -1, -1};
        controlDisponibilitatMissils = new boolean[]{true, true, true, true};   
    }
    
    
    public ArrayList getEnemicsStatus() {
        return enemicsStatus;
    }
    
    public int getEnemicsAtacats() {
        return enemicsAtacats;
    }
   
    public void setEnemicsAtacats(int enemicsAtacats) {
        this.enemicsAtacats = enemicsAtacats;
    }
   
    public void setObjectivoAlcanzado(int misilId) {
    }

    public void setEnemicsStatus() {
        for(int i=0; i<enemicsStatus.size(); i++){
            if(enemicsStatus.get(i).equals("viu")){
                enemicsStatus.set(i,"mort");
                break;
            }
        }
    }
    
    public void atacAmbRadar(Radar_ZaslonM radar, int numEnemicsDetectats) throws InterruptedException {
        Thread[] missils = new Thread[32];
        for(int i=0; i<32; i++){
            missils[i] = new R37(i,radar);
            missils[i].setName("missilR37_"+i);
        }
        System.out.println("Creat array de Threads (32) R37 amb noms des de missilR37_0 fins a missilR37_31");
        enemicsStatus = new ArrayList(numEnemicsDetectats);
        for(int i=0; i<numEnemicsDetectats; i++){
            enemicsStatus.add("viu");
        }

        int missilsActivats = 0;
        Thread threadInactiu = null;
        for(int i=0; i<missils.length; i++){
            if(missils[i].isAlive()){
                missilsActivats++;
            } else{
                threadInactiu = missils[i];
                break;
            }
        }
        if(missilsActivats < numEnemicsDetectats){
            System.out.println(threadInactiu.getName()+".start(); Trobats "+missilsActivats+" threads actius abans");
            threadInactiu.start();
        } else {
            for(Thread thread : missils){
                if(!thread.isAlive())break;
                System.out.println("--------------------- Radar ZaslonM: Esperant a que acabin tots els missils llançats, abans el join()");
                thread.join();
            }
        }
    }
    
    
    public synchronized Integer connectarseAlRadar (int missilId) {
        for(int i = 0; i<controlDisponibilitatMissils.length; i++){
            if(controlDisponibilitatMissils[i]){
                controlDisponibilitatMissils[i] = false;
                controlMissils[i] = missilId;
                System.out.println(Thread.currentThread().getName()+" s'ha conectat al radar en la posicion "+i+", missil DISPARAT");
                return i;
            }
        }
        return -1;
    }
    
    
    public synchronized void desconnectarseDelRadar(Integer posControlMissils, String nomThread){
        controlDisponibilitatMissils[posControlMissils] = false;
        controlMissils[posControlMissils] = -1;
        System.out.println(nomThread+".desconnectarseDelRadar(),actualizant enemicsStatus = "+enemicsStatus.toString());
    }
    
    
    
}
