package SinkADotCom;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class sinkDotComGame1{
    public ArrayList<String> locationCells;
    String name;
    int numberOfHits=0;
    public sinkDotComGame1(String name){ this.name=name; }
    public String checkYourSelf(String guess){
        boolean flag=locationCells.contains(guess);
        if(!flag){ return "Miss"; }
        else {
            numberOfHits++;
            int index=locationCells.indexOf(guess);
            if(index >=0){ locationCells.remove(index);  }
            if(locationCells.isEmpty() ){ return "Kill"; }
            else { return "Hit"; }
        }
    }
    public void setLocationCells(ArrayList<String> loc){ locationCells =loc; }
}