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
        int count = 0;

        while (lineReader.readLine() != null){
            numOfLines++;
        } 
        lineReader.close();

        while(inputFile.hasNextLine() != false){
            if(inputFile.hasNextInt()){        
                count++;
                System.out.println(count);
            }
        } 

        System.out.println(numOfLines);
        System.out.println(count);
       
        String[][] students = new String[numOfLines/count][count/6];

        for(int i = 0; i < students.length; i++){
            for(int z = 0; z < students[i].length; z++){
                System.out.println(students[i][z]);
            }
        }

        // while(inputFile.hasNextLine()){
        //     readStudents(inputFile, students);
        // }
    }
    
    public static void readStudents(Scanner inputFile, String[][] students){
        for(int i = 0; i < students.length -1; i++){
            for(int z = 0; z < students[i].length -1; z++){
                students[i][z] = inputFile.nextLine();
                System.out.println(students[i][z]);
                System.out.println("done");
            }
        }
    }
    
}

