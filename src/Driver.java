import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Andrew on 4/24/2017.
 */
public class Driver {

    public static void main(String[] args){
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader(args[0]));
            String currentLine;
            while((currentLine = input.readLine()) != null){
                String[] inputs = currentLine.split(" ");
                for(String s : inputs){

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
