/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nphan17
 */
public class Roster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("roster-2015.txt");
        Logger logger = Logger.getLogger(Roster.class.getName());
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

}
