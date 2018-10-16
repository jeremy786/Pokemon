/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;


/**
 *
 * @author Jeremiah
 */
public class Pattern{
     /**
      * The pattern is stored as a consecutive characters in a string
      */
    private String pattern;
    /**
     * The pattern to be created from the string, each character representing a type
     * @param p the string to be used as a pattern
     */
    public Pattern(String p){
        this.pattern = p;
    }
    /**
     * Returns the stored pattern
     * @return member pattern
     */
    public String getPattern(){
        return this.pattern;
    }
    /**
     * Returns a hash based from the pattern string in order to use for the hash map
     * @return returns the hash
     */
    @Override
    public int hashCode(){
        return this.pattern.hashCode();
    }
    
    public String toString(){
        return this.pattern.toString();
    }
    /**
     * for use in the hashmap implementation
     * @param o Ojbect to compare to
     * @return 
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Pattern){
            String str = ((Pattern)o).getPattern();         
            return this.pattern.equals(str);
        }
        else
            return false;
    }
}
