import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class Main {
    public static void main(String [] args) throws IOException {
        String[] array;
        FileInputStream fileByteStream = new FileInputStream("input.txt");
        Scanner inputFile = new Scanner(fileByteStream);
        while(inputFile.hasNextLine()){
            readStudents(inputFile, array);
        }
    }
    public static void readStudents(Scanner inputFile, String[] students){
        for(int i = 0; i < students.length; i++){
            students[i] = inputFile.nextLine();
        }
    }

}

