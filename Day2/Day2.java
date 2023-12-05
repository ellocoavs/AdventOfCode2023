package Day2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import org.apache.commons.lang3.*;
import java.util.HashMap;
import Commons.*;

public class Day2 {
    static String filename;
    static boolean test = false;
    static String day = "Day2";
    static int testanswer1 = 8;
    static int testanswer2 = 2286;

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
        int red = 12;
        int green = 13;
        int blue = 14;
        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);
            int gameNum = 0;
            Boolean gamePossible = true;
            Scanner scan = new Scanner(current);
            
            String next = scan.next(); //Game
            
            next = scan.next();//grabbed game number     leftover: x blue, x green, x red
            gameNum = Integer.parseInt(next.strip().replaceAll(":","")); //remove leading space and annoying colon
            System.out.println("Current game id is: "+gameNum);
            
            scan.useDelimiter(";");
            while (scan.hasNext()){
                String set = scan.next();
                System.out.println("Set x is: " +set);
                if (!isSetPossible(set, red, green, blue)){ //if the set was NOT possible the game is not possible
                    gamePossible = false;
                }
            }
            if (gamePossible){ //if the game was possible, add up it's ID
                answer = answer+gameNum;
            }
            
        }
        return answer;
    }

    public static boolean isSetPossible(String input, int red, int green, int blue ){
        Boolean answer = true; //we'll assume set is possible unless we find an impossibility
        Scanner setscanner = new Scanner(input);
        setscanner.useDelimiter(",");
        while (setscanner.hasNext()){
            //grab number and color and check. if false return false immediately
            String set = setscanner.next();
           // System.out.println(set);
            int number = Integer.parseInt(StringUtils.getDigits(set));
            String color = set.replaceAll("\\d", "").strip();
            //System.out.println("Found color: "+color+" and number: " +number);
            if (color.equals("red") && number > red ){
                return false;
            }
            if (color.equals("green") && number > green ){
                return false;
            }
            if (color.equals("blue") && number > blue ){
                return false;
            }
        }
        return answer;
    }

    private static int part2(List<String> input) {
        int answer = 0;
        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);
            int red = 0; int blue = 0; int green = 0;
            int gameNum = 0;

            Scanner scan = new Scanner(current);
            String next = scan.next(); //Game
            next = scan.next();//grabbed game number     leftover: x blue, x green, x red
            gameNum = Integer.parseInt(next.strip().replaceAll(":","")); //remove leading space and annoying colon
            System.out.println("Current game id is: "+gameNum);
            
            scan.useDelimiter(";");
            while (scan.hasNext()){
                String set = scan.next();
                System.out.println("Set x is: " +set);
                int tempRed = maxColor(set,"red");
                int tempGreen = maxColor(set,"green");
                int tempBlue = maxColor(set,"blue");
                if (tempRed > red){red=tempRed;}
                if (tempGreen > green){green=tempGreen;}
                if (tempBlue > blue){blue=tempBlue;}
            }
            System.out.println("Found values for R G B: "+red+" "+green+" "+blue);
            answer = answer + (red*green*blue);
        }
        return answer;
    }

    public static int maxColor(String input, String colorFind){
        int answer;
        int red = 0; int blue = 0; int green = 0;
        Scanner setscanner = new Scanner(input);
        setscanner.useDelimiter(",");
        while (setscanner.hasNext()){
            //grab number and color and check. if false return false immediately
            String set = setscanner.next();
           // System.out.println(set);
            int number = Integer.parseInt(StringUtils.getDigits(set));
            String color = set.replaceAll("\\d", "").strip();
            //System.out.println("Found color: "+color+" and number: " +number);
            if (color.equals(colorFind) && color.equals("red")){
                if (number > red){
                    red = number;
                }
            }
            if (color.equals(colorFind) && color.equals("green")){
                if (number > green){
                    green = number;
                }
            }
            if (color.equals(colorFind) && color.equals("blue")){
                if (number > blue){
                blue = number;
                }
            }
        }
        System.out.println("Found RGB: " +red+" "+green+" "+blue);
        answer = blue+red+green; //all zeroes except the one we were finding.
        return answer;
    }
}
