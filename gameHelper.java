package SinkADotCom;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class gameHelper{
    private static final String alphabet="abcdefg";
    private int gridLength=7; //length and width of the grid are equal
    static ArrayList<String> placed=new ArrayList<>();

    public String getUserInput(String prompt){
        System.out.print(prompt +" ");
        String guess;
        guess=new Scanner(System.in).nextLine();
        return guess;
    }

    public ArrayList<String> placeDotCom(){
        int num1,num2,vertical;
        Random rand=new Random();
        vertical=rand.nextInt(2);
        boolean flag=false;
        ArrayList<String> dotCom =new ArrayList<>();
        String randomString;
        //boolean check;
        while(!flag){
            num1=rand.nextInt(gridLength);  //row
            num2=rand.nextInt(alphabet.length()-2);
            if(vertical == 1){
                //place vertical
                for(int i=0;i<3;i++) {
                    randomString = alphabet.charAt(num2+i) +Integer.toString(num1);
                    if( checkValidity(dotCom,randomString)   ){ placeValid(dotCom,randomString); }
                    else { break; }
                }
            }else {
                //place horizontal
                for(int i=0;i<3;i++) {
                    randomString = alphabet.charAt(num1) + Integer.toString(num2 + i);
                    if( checkValidity(dotCom,randomString)   ){ placeValid(dotCom,randomString); }
                    else { break; }
                }
            }
            if(dotCom.size() == 3){
                flag=true;
            }
        }
        return dotCom;
    }

    //checks if the randomly generated string qualifies to be placed in the dotCom or not
    public boolean checkValidity(ArrayList<String> dotCom,String randomString){
        if(placed.size()!= 0 && placed.contains(randomString)) {
            for (int i = dotCom.size() - 1; i >= 0; i--) {
                dotCom.remove(i);
                placed.remove(placed.size()-1-i );
            }
            return false ;
        }
        else { return true; }
    }
    //place the randomly generated String if it is valid
    public void placeValid(ArrayList<String> dotCom,String randomString){
        placed.add(randomString);
        dotCom.add(randomString);
        //System.out.println("placed "+randomString);
    }
}

