/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Jeremiah
 */
public class Computer {
    
    /**
     * member stores the patterns in a hashmap
     */
    private HashMap<Pattern,Integer> patterns;
    /**
     * construct new Computer to handle the opposite player,
     * Handles
     *  Guessing player moves
     *  Countering to win
     * Stores pattern in hashmap
     */
    public Computer(){
        this.patterns = new HashMap<>();
    }
    /**
     * Makes a prediction on what the player will do
     * @param p uses a string containing the pattern to make a prediction
     * @return 
     */
    public char makePredictions(String p){
        return ' ';
    }
    /**
     * Stores the pattern in the form of a string to the hashmap
     * @param p the pattern to be stored
     */
    public void storePatterns(String p){
        Pattern pat = new Pattern(p);
        
        if(this.patterns.containsKey(pat)){
            int i = this.patterns.get(pat);
            this.patterns.remove(pat);
            this.patterns.put(pat, ++i);
        }
        else
            this.patterns.put(pat,1);
    }
    /**
     * Saves the patterns from the hashmap to a file
     * @param f File that will be saved to
     */
    public void saveMapToFile(File f) throws FileNotFoundException, IOException{
        try{
            FileWriter writer = new FileWriter(f);
            writer.write(this.patterns.toString());
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.print("File has not been found!");
            throw e;
        }
        catch(IOException e){
            System.out.print("There is a writing error");
            throw e;
        }
    }
    /**
     * Reads patterns from a file to use against the player
     * @param f File to read the patterns from
     * @return 
     */
    public String readFile(File f){
        return " ";
    }
}
