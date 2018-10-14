/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jeremiah 
 * Program is a game that uses a hashmap to store player patterns to use as a prediction to beat the player
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     * function used as a main controller to flow throw the game, receive inputs and display outputs
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("TestFile.txt");
        
        Computer cpu = new Computer();
        
        cpu.storePatterns("This is a test Pattern1");
        cpu.storePatterns("This is a test Pattern2");
        cpu.storePatterns("This is a test Pattern2");
        cpu.storePatterns("This is a test Pattern3");
        cpu.storePatterns("This is a test Pattern3");
        cpu.storePatterns("This is a test Pattern3");

        try{
            cpu.saveMapToFile(file);
        }
        catch(FileNotFoundException e){   
        }
        catch(IOException e){
        }
    }
    
}
