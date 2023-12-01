package Commons;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;

/**
 * Some tools to be used
 */
public class Tools {         
    public static List<String> readInput(String filename)  {
        System.out.println("Reading Input");
            List<String> input = new ArrayList<>();
            try {
                input = Files.readAllLines(Paths.get(filename));
            }
            catch(IOException io){
                io.printStackTrace();
            }
            return input;

    }
    public static void printInput(List<String> input){
        System.out.println("Printing input");
            for (String string : input) {
                System.out.println(string);
            }

    }
    public static String setInputfile(boolean test, String day){
        String filename;
        if (test){
            filename = "./"+day+"/testinput.txt";
        }
        else{
            filename = "./"+day+"/input.txt";
        }
        return filename;
    }

    public static char[] splitLineDay2 (String line){
        char[] split = new char[2];
        split[0] = line.charAt(0);
        split[1] = line.charAt(2);
        return split;
    }

    public static String[] splitOnComma (String line){
        return line.split(",");
    }

    public static String[] splitOnDash (String line){
        return line.split("-");
    }
}