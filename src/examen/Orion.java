/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gmartinez
 */
public class Orion {
    public static void menuOrion() throws IOException, InterruptedException {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        int numEnemicsDetectats = 0;
        
        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("RPO Orion-A");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("1. Detectar enemics");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("10. Atac amb radar Zaslon-M");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("20. Atac amb sistema de guia infraroja IRST");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            switch (opcio) {
                case "1":
                    numEnemicsDetectats = detectarEnemics();
                    break;
                case "10":
                    inicialitzaAtacAmbRadar(numEnemicsDetectats);
                    break;
                case "20":
                    inicialitzaAtacAmbIRST(numEnemicsDetectats);
                    break;
                case "50":
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }   
        } while (!opcio.equals("50"));
    }
    
    
    public static int detectarEnemics(){
        return 9;
    }
    
    
    public static void inicialitzaAtacAmbRadar(int numEnemicsDetectats) throws InterruptedException {
        System.out.println("RPO Orion-A: atac amb radar Zaslon-M: ---- INICI ----");

        Radar_ZaslonM radar_zaslonM = new Radar_ZaslonM();
        radar_zaslonM.atacAmbRadar(radar_zaslonM,numEnemicsDetectats);
        
        System.out.println("RPO Orion-A: atac amb radar Zaslon-M: ---- FI ----");
        System.out.println();
    }
    
    
    public static void inicialitzaAtacAmbIRST(int numEnemicsDetectats){
        System.out.println("RPO Orion-A: atac amb sistema de guia infraroja IRST: ---- INICI ----");

        GuiaInfrarroja_IRST guiaInfrarroja_irst = new GuiaInfrarroja_IRST();
        guiaInfrarroja_irst.atacAmbIRST(guiaInfrarroja_irst,numEnemicsDetectats);
        
        System.out.println("RPO Orion-A: atac amb sistema de guia infraroja IRST: ---- FI ----");
        System.out.println();
    }
}
