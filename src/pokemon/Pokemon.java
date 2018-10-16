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
        //Initiate variables
        File file = new File("TestFile.txt");
        Queue<Character> q= new LinkedList<>();
        Computer cpu = new Computer();
        int p1Wins=0,draws=0,cpuWins=0;
        cpu.readFile(file);
        
        //Start menu
        String menu="0. Exit\n1. Fire\n2. Water\n3. Grass";
        System.out.println(menu);
        int input = CheckInput.getIntRange(0,3);
        //Check and handle input
        while(input>0&&input<4){
            char type=' ';
            String pattern="";
            switch(input){
                case 1:
                    type='f';
                    break;
                case 2:
                    type='w';
                    break;
                case 3:
                    type='g';
                    break;
            }//Pump into queue and update the pattern
            q.add(type);
            for(char c:q)
                pattern+=c;
            
            

            if(q.size()>6){//Pattern should be a certain size, dequeue the front
                cpu.storePatterns(pattern);
                q.remove();
            }//Make prediction
            char prediction=cpu.makePredictions(pattern);
            char cpuMove;//Counter prediction
            switch(prediction){
                case 'f':
                    cpuMove='w';
                    break;
                case 'w':
                    cpuMove='g';
                    break;
                case 'g':
                    cpuMove='f';
                    break;
                default:
                    cpuMove='f';
                    break;
            }
            
            //Display outcomes
            System.out.println("You chose: "+type+" Cpu chose: "+cpuMove);
            
            switch(cpuMove){
                case 'f':
                    switch(type){
                        case 'f':draws++;System.out.println("It was a draw!");break;
                        case 'g':cpuWins++;System.out.println("Cpu wins the round!");break;
                        case 'w':p1Wins++;System.out.println("Player wins the round!");
                        break;           
                    }
                    break;
                case 'g':
                    switch(type){
                        case 'f':p1Wins++;System.out.println("Player wins the round!");break;
                        case 'g':draws++;System.out.println("It was a draw!");break;
                        case 'w':cpuWins++;System.out.println("Cpu wins the round!");
                        break;           
                    }
                       break;
                case 'w':
                    switch(type){
                        case 'f':cpuWins++;System.out.println("Cpu wins the round!");break;
                        case 'g':p1Wins++;System.out.println("Player wins the round!");break;
                        case 'w':draws++;System.out.println("It was a draw!");
                        break;           
                    }   
                break;           
            }
            //Display current scores
            System.out.println("The current score is:\nWins: "+p1Wins+" Loses: "+cpuWins+"\nDraws: "+draws+" Win-Loss Ratio: "+ (double)p1Wins/(double)(p1Wins+cpuWins)*100+"%");
            //Restart menu
           System.out.println(menu);
           input = CheckInput.getIntRange(0,3);
        }//Ask to save, complete task if necesary
        System.out.println("Do you wish to save game pattern data?(y/n,yes/no)");
        if(CheckInput.getYesNo()==1)
            cpu.saveMapToFile(file);

    }
    
}

