/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.Calendar;

/**
 *
 * @author gmartinez
 */
public class DatesVisualitzar {
    public static String calculaDiaDeLaSetmana(int numDia) {
        String nomDia = null;
        
        switch (numDia){
            case 1: nomDia = "Dilluns";
                    break;
            case 2: nomDia = "Dimarts";
                    break;
            case 3: nomDia = "Dimecres";
                    break;
            case 4: nomDia = "Dijous";
                    break;
            case 5: nomDia = "Divendres";
                    break;
            case 6: nomDia = "Dissabte";
                    break;
            case 7: nomDia = "Diumenge";
                    break;
            default: nomDia = "DIA DE LA SETMANA DESCONEGUT";
                    break;
        }
        
        return nomDia;
    }
    
    public static String visualitzarData(Calendar data){
        String dataTmp = "";
        
        if (data != null) {
            dataTmp = calculaDiaDeLaSetmana(data.get(Calendar.DAY_OF_WEEK)) + 
                    " " + data.get(Calendar.DAY_OF_MONTH) + "-" + (data.get(Calendar.MONTH) + 1)  + "-" + data.get(Calendar.YEAR) + 
                    " a les " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);
        } else {
            dataTmp = "null";
        }
        
        return dataTmp;
    }
}
