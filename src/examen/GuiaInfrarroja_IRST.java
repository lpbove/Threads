/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gines
 */

//La guia infrarroja IRST controlarà als míssils R-73 (32 míssils, 32 fils por tant) però només pot guiar 4 míssils a la vegada.
public class GuiaInfrarroja_IRST {
    private Integer[] controlMissils;                     //El IRST pot controlar 4 míssils simultàneament, en cada posició de l'array hi haurà el ID del míssil que controla.
    private boolean[] controlDisponibilitatMissils;       //A TRUE si encara es pot afegir algun míssil al controlMissils (es poden guiar 4 míssils simultàneamente).
    ArrayList<Integer> objectivoAlcanzado = new ArrayList<Integer>();	//Anem fican els Id dels míssils que fassin impacte.
    ArrayList enemicsStatus = new ArrayList();
    private int enemicsAtacats = 0;

    
    public GuiaInfrarroja_IRST() {
        controlMissils = new Integer[]{-1, -1, -1, -1};
        controlDisponibilitatMissils = new boolean[]{true, true, true, true};  
    }
    

    public ArrayList getEnemicsStatus() {
        return enemicsStatus;
    }

    public void setEnemicsAtacats(int enemicsAtacats) {
        this.enemicsAtacats = enemicsAtacats;
    }
    
    public void setObjectivoAlcanzado(int misilId) {
    }

    public void setEnemicsStatus() {
    }


    

    
    public void atacAmbIRST(GuiaInfrarroja_IRST IRST, int numEnemicsDetectats){
    }
    
    
    
    public Integer connectarseAlIRST(int misilId) {
        return -1;
    }
    
    
    public void desconnectarseDelIRST(Integer posControlMisiles, String nomThread){
    }
    

    
}
