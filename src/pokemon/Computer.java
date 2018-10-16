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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import javafx.util.Pair;
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
        ArrayList pairs= new ArrayList<Pair<Pattern,Integer>>();
        
        
        if(this.patterns.isEmpty()&&this.patterns.size()<5)
            switch((int)Math.round(Math.random()*2)){
                case 0:
                    return 'g';
                case 1:
                    return 'w';
                case 2:
                    return 'f';
                default:
                    return 'f';
            }
            int i;
        for (Pattern key : this.patterns.keySet()) { 
            i=key.getPattern().indexOf(p);
            
            
        }
    
            
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
    public void saveMapToFile(File f) {
        try{
            FileWriter writer = new FileWriter(f);
            writer.write(this.patterns.toString());
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.print("File has not been found!");
        }
        catch(IOException e){
            System.out.print("There is a writing error");
        }
    }
    /**
     * Reads patterns from a file to use against the player
     * @param f File to read the patterns from
     * @return 
     */
    public String readFile(File f){
        
        try{
            Scanner scan = new Scanner(f);
            
            String text="";
            if(scan.hasNext())
                text= scan.nextLine();
            
            while(scan.hasNext()){
             text+=scan.nextLine();
            }
            
            if(text.charAt(0)=='{'){
                text=text.substring(1);
                text=text.substring(0, text.length()-1);
            }
            String textArr[]=text.split(", ");
            String temp[];
            for(String pat: textArr){
                temp=pat.split("=");
                this.patterns.put(new Pattern(temp[0]), Integer.parseInt(temp[1])); 
            }
        }
        catch(FileNotFoundException e){
            System.out.print("File not found.");
        }
        return "File Success";
    }
}
