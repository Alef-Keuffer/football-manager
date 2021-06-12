/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernandobicalho
 */
public class ExportToTxt {
        
    private static void logToTxt(){  
        try {
        String fileName = new SimpleDateFormat("logs.txt'").format(new Date());
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        
        //Deve surgir no ficheiro:
        //Equipa: Nome equipa
        //Posição: Nome + atributos
        //
        //Jogo: Equipa x, equipa y, resultado(x,y), data, num camisolas equipa x, subs equipa x, num camisolas equipa y, subs equipa y
        
        writer.write("Something" + variable.getText() + "\n");
        writer.write("Something" + variable.getText() + "\n");
        writer.write("Something" + variable.getText() + "\n");
        writer.write("Something" + variable.getText() + "\n");
        
        writer.close();
    } catch(Exception ex) {
        ex.printStackTrace();
    }
        
    }
}
