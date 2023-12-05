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
            System.out.println("Currently checking: " + current);   //NEED TO REVERSe. FIND ALL NUMBERS INSTEAD. Q_Q
            for (int x=0; x<current.length();x++){ //loops through line looking at each character to see if its a symbol, so it's X coord
                if (!Character.isDigit(current.charAt(x)) && !(current.charAt(x) == '.') ){ //not number and not . -> symbol!
                    coords.add(new Coordinates(x, linecounter));
                }
            }
            linecounter++;
        }
        //we now have list of coords for ALL symbols. Now we find their touching number. 8 spots to check. COULD BE MULTIPLE
        for (Coordinates coordinate : coords) {
            answer += addTouchingNumbers(coordinate,input);
        }
        return answer;
    }


    private static int addTouchingNumbers(Coordinates coord, List<String> input) {
        int total = 0;
        //we check from line numbers y-1 , y , y+1 and x coords x-1, x x+1. excepting x,y. if theres a number we have to go left and right until there's not a number.
        int y = coord.getY();
        int x = coord.getX();

        return total;
    }

    private static int part2(List<String> input) {
        int answer = 0;
        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
        }
        return answer;
    }

}
