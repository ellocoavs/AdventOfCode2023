package Day3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import org.apache.commons.lang3.*;
import java.util.HashMap;
import java.util.HashSet;
import Commons.*;

public class Day3 {
    static String filename;
    static boolean test = false;
    static String day = "Day3";
    static int testanswer1 = 4361;
    static int testanswer2 = 0;

    public static void main(String[] args) {
        filename = Tools.setInputfile(test, day);
        List<String> input = Tools.readInput(filename);
        Tools.printInput(input);

        //Answer part 1
        int answer1 = part1(input);
        System.out.println("Answer1 is: " + Integer.toString(answer1));
        if (test){
            if (testanswer1 == answer1){
                System.out.println("Test for part 1 succesful");
            }
            else{
                System.out.println("Test for part 1 failed");
            }
        }
        
        int answer2 = part2(input);        
        System.out.println("Answer2 is: " + Integer.toString(answer2));

        if (test){
            if (testanswer2 == answer2){
                System.out.println("Test for part 2 succesful");
            }
            else{
                System.out.println("Test for part 2 failed");
            }

        }
    }

    public static int part1(List<String> input) {
        int answer = 0;
        //Make list of coords for easy non-number, non-period symbol.
        //then find the number attached to it.
        //add those numbers up.
        List<Coordinates> coords = new ArrayList<Coordinates>();
        ListIterator<String> iterator = input.listIterator();
        int linecounter = 0; //this is also our y coord
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);   //NEED TO REVERSe. FIND ALL NUMBERS INSTEAD. Q_Q MAX 3 digits!
            for (int x=0; x<current.length();x++){ //loops through line looking at each character to see if its a number
                if (Character.isDigit(current.charAt(x))){ // is number, now find how many digits are next to it. 0, 1 or 2

                    if (!Character.isDigit(current.charAt(x+1))){//next char is NOT a number -> single digit number
                        int number = Integer.parseInt(current.substring(x, x));
                        Coordinates addme = new Coordinates(x, linecounter, 1,number);
                        addme.isSymbolAttached(input);
                        coords.add(addme);
                        x++; // we can skip the next character, becasue it's known not to be a number
                    }
                    if (Character.isDigit(current.charAt(x+2))){  //next TWO chars are numbers -> 3 digit number
                        int number = Integer.parseInt(current.substring(x, x+2));
                        Coordinates addme = new Coordinates(x, linecounter, 3, number);
                        addme.isSymbolAttached(input);
                        coords.add(addme);
                        x = x + 3; //next 2 chars are numbers, then the one after HAS to not be a number, so skipp al over those.
                    }
                    else {
                        int number = Integer.parseInt(current.substring(x, x+1));
                        Coordinates addme = new Coordinates(x, linecounter, 2,number);
                        addme.isSymbolAttached(input);
                        coords.add(addme);// else 2 digit number
                        x = x + 2;
                    }
                }
            }
            linecounter++;
        }
        //we now have list of coords for ALL symbols. Now we find their touching number. 8 spots to check. COULD BE MULTIPLE
        for (Coordinates coord : coords) {
            if (coord.getSymbolAttached()){
                coord.getNumber();
            }
            
        }
        return answer;
    }



    private static int part2(List<String> input) {
        int answer = 0;
        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
        }
        return answer;
    }

}
