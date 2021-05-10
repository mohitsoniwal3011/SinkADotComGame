package SinkADotCom;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class dotComBust{
    private gameHelper helper=new gameHelper();
    private ArrayList<sinkDotComGame1> dotComList=new ArrayList<>();
    private int numberOfGuesses =0;
    public void setupGame(){

        sinkDotComGame1 one =new sinkDotComGame1("Pets.com");
        sinkDotComGame1 two =new sinkDotComGame1("Toys.com");
        sinkDotComGame1 three=new sinkDotComGame1("Titan.com");
        one.setLocationCells(helper.placeDotCom());
        two.setLocationCells(helper.placeDotCom());
        three.setLocationCells(helper.placeDotCom());

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Your goal is to sink the three dot coms.");
        System.out.println("Pets.com ,Toys.com and Titan.com");
        System.out.println("Try to sink them all in fewest number of guesses");
    }
    public void startGame(){
        while(!dotComList.isEmpty()){
            numberOfGuesses++;
            String userInput= helper.getUserInput("Enter your guess:");
            String result="Miss";
            for(int i=0;i<dotComList.size() ;i++){
                result=dotComList.get(i).checkYourSelf(userInput);
                if(result.equals("Kill")){
                    System.out.println("Ouch! You sunk "+dotComList.get(i).name);
                    dotComList.remove(i);
                    break;
                }
                if(result.equals("Hit")){
                    System.out.println(result);
                    break;
                }
            }
            if(result.equals("Miss")){ System.out.println(result); }

        }
        finishGame();
    }
    public void finishGame(){
        System.out.println("All the Dot Coms are Dead! Your stock is now worthless");
        if(numberOfGuesses <=  18){
            System.out.println("It only took you "+numberOfGuesses+" guesses");
            System.out.println("You got out before your option sank!");
        }
        else {
            System.out.println("Took you long enough "+numberOfGuesses+" guesses");
            System.out.println("Fish are dancing with your options ");
        }
    }
}