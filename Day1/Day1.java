package Day1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import org.apache.commons.lang3.*;
import java.util.HashMap;
import Commons.*;

public class Day1 {
    static String filename;
    static boolean test = true;
    static String day = "Day1";
    static int testanswer1 = 142;
    static int testanswer2 = 281;

    public static void main(String[] args) {
        filename = Tools.setInputfile(test, day);
        List<String> input = Tools.readInput(filename);
        Tools.printInput(input);

        //Answer part 1
        /*int answer1 = part1(input);
        System.out.println("Answer1 is: " + Integer.toString(answer1));
        if (test){
            if (testanswer1 == answer1){
                System.out.println("Test for part 1 succesful");
            }
            else{
                System.out.println("Test for part 1 failed");
            }
        }
        */
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
            for (int i=0;i<current.length(); i++){
                System.out.println("We are checking at index: "+i +". This is char: "+current.substring(i, i+1));
                
                if(StringUtils.isNumeric(current.substring(i, i+1))){
                    if (first == null){
                        first = current.substring(i,i+1);
                        System.out.println("First number is: "+first);
                    }
                    if (last == null){
                        last = first;
                        System.out.println("Last number is temporarily? set to: "+last);
                    }
                    else {
                        last = current.substring(i,i+1);
                        System.out.println("Last number is temporarily? set to: "+last);
                    }
                } 
            }
            System.out.println("Adding: " +first+last + " to runningtotal");
            runningtotal = runningtotal + Integer.parseInt(first+last);
        }
        answer = runningtotal;
        return answer;
    }

    private static int part2(List<String> input) {
        int answer = 0;
        int runningtotal = 0;
        HashMap<Integer,String> nums = new HashMap<>();

        nums.put(1,"one"  );
        nums.put(2,"two"  );
        nums.put(3,"three");
        nums.put(4,"four" );
        nums.put(5,"five" );
        nums.put(6,"six"  );
        nums.put(7,"seven");
        nums.put(8,"eight");
        nums.put(9,"nine" );

        //need to check if the strings in nums are present in the next 5 chars IF the next char is not a number.
        //UGH HEADACHE
        ListIterator<String> iterator = input.listIterator();
        String first = null;
        String last = null;
        while (iterator.hasNext()){
            String current = iterator.next();
            System.out.println("Currently checking: " + current);
            first = null;
            last = null;
            for (int i=0; i<current.length();i++){
                System.out.println("Numbers are now: "+first+last);
                if (first == null && StringUtils.isNumeric(current.substring(i,i+1))){
                    first = current.substring(i,i+1);
                    last = first;
                    System.out.println("First number is: "+first);
                    continue;
                }
                //if next five chars contain a spelled out number...
                else if (first == null){
                    if (current.substring(i, i+4).contains(nums.get(1))){
                        first = "1";
                        last = first;
                        i=i+2;
                        continue;
                    }
                    if (current.substring(i, i+4).contains(nums.get(2))){
                        first = "2";
                        last = first;
                        i=i+2;
                        continue;
                    }
                    if (current.substring(i, i+5).contains(nums.get(3))){
                        first = "3";
                        last = first;
                        i=i+3;
                        continue;
                    }
                    if (current.substring(i, i+4).contains(nums.get(4))){
                        first = "4";
                        last = first;
                        i=i+2;
                        continue;
                    }
                    if (current.substring(i, i+4).contains(nums.get(5))){
                        first = "5";
                        last = first;
                        i=i+2;
                        continue;
                    }
                    if (current.substring(i, i+4).contains(nums.get(6))){
                        first = "6";
                        last = first;
                        i=i+2;
                        continue;
                    }
                    if (current.substring(i, i+5).contains(nums.get(7))){
                        first = "7";
                        last = first;
                        i=i+3;
                        continue;
                    }
                    if (current.substring(i, i+5).contains(nums.get(8))){
                        first = "8";
                        last = first;
                        i=i+5;
                        continue;
                    }
                    if (current.substring(i, i+4).contains(nums.get(9))){
                        first = "9";
                        last = first;
                        i=i+2;
                        continue;
                    }
                
                }
                else { //just checking for last number.
                    if (StringUtils.isNumeric(current.substring(i,i+1))){
                        last = current.substring(i,i+1);
                        System.out.println("Last number is: "+last);
                        continue;
                    }
                    
                    if (i+3 >= current.length()){break;}
                    System.out.println("Now peeking at: " + current.substring(i, i+3));
                    if (i+4 < current.length()){                   
                        if (current.substring(i, i+5).contains(nums.get(3))){
                            last = "3";
                            i=i+4;
                            continue;
                        }
                   
                        if (current.substring(i, i+5).contains(nums.get(7))){
                            last = "7";
                            i=i+4;
                            continue;
                        }
                        if (current.substring(i, i+5).contains(nums.get(8))){
                            last = "8";
                            i=i+4;
                            continue;
                        }
                     
                    }
                        //SOMETIMES WE DONT GET HER?E?!!?!? xtwone3four
                    else if (i+3 < current.length()){                 
                        if (current.substring(i, i+4).contains(nums.get(1))){
                            last = "1";
                            i=i+3;
                            continue;
                        }
                        if (current.substring(i, i+4).contains(nums.get(2))){
                            last = "2";
                            i=i+3;
                            continue;
                        }
                        if (current.substring(i, i+4).contains(nums.get(4))){
                            last = "4";
                            i=i+3;
                            continue;
                        }
                        if (current.substring(i, i+4).contains(nums.get(5))){
                            last = "5";
                            i=i+3;
                            continue;
                        }
                        if (current.substring(i, i+4).contains(nums.get(6))){
                            last = "6";
                            i=i+3;
                            continue;
                        }
                        if (current.substring(i, i+4).contains(nums.get(9))){
                            last = "9";
                            i=i+3;
                            continue;
                        }
                    }   
                }
                System.out.println("Numbers are now: "+first+last);
            }
            System.out.println("Numbers are now: "+first+last);
        }
        System.out.println("Numbers are now: "+first+last);
        answer = runningtotal;
        return answer;
    }
}
