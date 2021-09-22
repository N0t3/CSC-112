import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;  

public class Main {
    public static void main(String [] args) throws IOException {
        FileInputStream fileByteStream = new FileInputStream("input.txt");
        Scanner inputFile = new Scanner(fileByteStream);

        BufferedReader lineReader = new BufferedReader(new FileReader("input.txt"));
        int numOfLines = 0;
        while (lineReader.readLine() != null) numOfLines++;
        lineReader.close();

        String[] students = new String[numOfLines];
        int[] arrayAvgGrades = new int[numOfLines]; 

        System.out.println("done");
        while(inputFile.hasNextLine()){
            readStudents(inputFile, students, arrayAvgGrades);
            
        }

    }
    public static void readStudents(Scanner inputFile, String[] students, int[] arrayAvgGrades){
        for(int i = 0; i < students.length; i++){
            if(inputFile.hasNextInt()){
                arrayAvgGrades[i] = inputFile.nextInt();
                System.out.println(arrayAvgGrades[i]);
            }
        }
    }
}

