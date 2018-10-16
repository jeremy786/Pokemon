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
     * Stores patterns in hashmap, patterns
     */
    public Computer(){
        //initialize 
        this.patterns = new HashMap<>();
    }
    /**
     * Makes a prediction on what the player will do
     * @param p uses a string containing the pattern to make a prediction
     * @return 
     */
    public char makePredictions(String p){
  //If the pattern isnt empty attempt to find a pattern
        if(!this.patterns.isEmpty())
            while(p.length()>0){
                //Shorten length of pattern if pattern isn't found every iteration
                for (Pattern key : this.patterns.keySet()) { 
                    //Iterate over every pattern in patterns
                    //Use regex to match the patterns to eachother
                    if(key.getPattern().matches("(f|g|w)*"+p+"(f|g|w)"))
                        //Need at least 1 character at the end to predict
                        //Extract the character after the matched pattern
                        return key.getPattern().charAt(key.getPattern().indexOf(p)+1);
                }
                //Subtract from the front of the string
                p=p.substring(1);
            }
        //Otherwise guess for the answer
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
    }
    /**
     * Stores the pattern in the form of a string to the hashmap
     * @param p the pattern to be stored
     */
    public void storePatterns(String p){
        //Turn the string into a new pattern
        Pattern pat = new Pattern(p);
        //Increase the value of the key if it already exists
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
        //Open Writer
        System.out.println("Saving Data....");
        try{
            FileWriter writer = new FileWriter(f);
            //Use toString default method to print
            writer.write(this.patterns.toString());
            //Saves changes
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.print("File has not been found!");
        }
        catch(IOException e){
            System.out.print("There is a writing error");
        }
                System.out.println("Done!");
    }
    /**
     * Reads patterns from a file to use against the player
     * @param f File to read the patterns from
     * @return 
     */
    public String readFile(File f){
        //Open file and read
        try{
            Scanner scan = new Scanner(f);
            
            String text="";
            //check if it has text
            if(scan.hasNext())
                text= scan.nextLine();
            //If there are other lines scan and add them to text string
            while(scan.hasNext()){
             text+=scan.nextLine();
            }
            //Format, get rid of first character
            if(text.charAt(0)=='{'){
                text=text.substring(1);
                text=text.substring(0, text.length()-1);
            }//Split into an array with ,  spacing
            String textArr[]=text.split(", ");
            String temp[];//then split by = between key and value
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
