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
    static boolean test = true;
    static String day = "Day2";
    static int testanswer1 = 8;
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
        int red = 20;
        int green = 13;
        int blue = 14;
        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);
            int gameNum = 0;
            Scanner scan = new Scanner(current);
            String next = scan.next(); //Game
            System.out.println(next);
            gameNum = scan.nextInt(); //x     leftover: : x blue, x green, x red
            System.out.println("Current game id is: "+gameNum);
            scan.next(); // remove :.  now we have 3 sets left separated by ;
            scan.useDelimiter(";");
            String set1 = scan.next();
            System.out.println("Set 1 is: " +set1);
            String set2 = scan.next();
            System.out.println("Set 2 is: " +set2);
            String set3 = scan.next();
            System.out.println("Set 3 is: " +set3);
        }
        return answer;
    }

    public static boolean isGamePossible(String input, int red, int green, int blue ){
        Boolean answer = false;

        return answer;
    }

    private static int part2(List<String> input) {
            int answer = 0;
        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);
        }
        return answer;
    }
}
