package Day1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import org.apache.commons.lang3.*;
import Commons.*;

public class Day1 {
    static String filename;
    static boolean test = true;
    static String day = "Day1";
    static int testanswer1 = 142;
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
        int runningtotal = 0;

        ListIterator<String> iterator = input.listIterator();
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);
            String first = null;
            String last = null;
            for (int i=0;i<current.length()-1; i++){
                if(StringUtils.isNumeric(current.substring(i, 1))){
                    if (first == null){
                        first = current.substring(0,1);
                        System.out.println("First number is: "+first);
                    }
                    if (last == null){
                        first = last;
                        System.out.println("Last number is temporarily? set to: "+first);
                    }
                    else {last = current.substring(i,1);}
                } 
            }
            runningtotal = runningtotal + Integer.parseInt(first+last);
        }
        answer = runningtotal;
        return answer;
    }

    private static int part2(List<String> input) {
        return 0;
    }
}
