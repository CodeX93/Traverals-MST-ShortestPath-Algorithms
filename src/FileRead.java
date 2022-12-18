import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
    static ArrayList<Integer> source = new ArrayList<>();
    static   ArrayList<Integer> destination = new ArrayList<>();
    void readFromFile(){
        try {
            File myObj = new File("/Users/aghashahhyder/Desktop/University/Semester5/DesignNAnalysis-Algorithms/Project/demo/src/f.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine() ) {
                String data = myReader.nextLine();
                String strings[] = data.split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);
                source.add(x);
                destination.add(y);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
