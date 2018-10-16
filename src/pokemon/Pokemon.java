/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


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
        Queue<Character> q= new LinkedList<>();
        Computer cpu = new Computer();
        String pat = "";
        int i =0;
        cpu.readFile(file);
        
         q.add('f');
         System.out.print(q.size());
         q.add('w');
         System.out.print(q.size());
         q.add('g');
         System.out.print(q.size());
         q.add('w');
         System.out.print(q.size());
         q.add('f');
        
        for(char c:q){
            pat+=c;
        }
        
        
        q.poll();
        System.out.print(q.size());
        q.add('g');
        System.out.print(q.size());
        
        pat="";
        
         for(char c:q){
            pat+=c;
        }
        
        cpu.storePatterns(pat);


        cpu.saveMapToFile(file);
        
            
    }
    
}
