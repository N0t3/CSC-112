import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;  
import java.util.Arrays;

public class Main {
    public static void main(String [] args) throws IOException {
        FileInputStream fileByteStream = new FileInputStream("input.txt");
        Scanner inputFile = new Scanner(fileByteStream);

        FileInputStream fileByteStreamTwo = new FileInputStream("input.txt");
        Scanner inputFileTwo = new Scanner(fileByteStreamTwo);

        int countStudents = 0;
        int countInt = 0;

        while(inputFile.hasNextLine()){
            if(inputFile.hasNextInt()){        
                countInt++;
            }else{
                countStudents++;
            }
            inputFile.nextLine();
        } 
       
        String[][] students = new String[countStudents +1][9];
        
        while(inputFileTwo.hasNextLine()){
            readStudents(inputFileTwo, students);
        }

        for(int i = 0; i < students.length; i++){
            for(int z = 0; z < students[i].length; z++){
                System.out.println(students[0][z]);
            }
        }
        System.out.println(Arrays.deepToString(students));
    }
    
    public static void readStudents(Scanner x, String[][] students){
        for(int i = 0; i < students.length -1; i++){
            for(int z = 0; z < students[i].length; z++){
                if(x.hasNextLine()){
                    students[i][z] = x.next();
                    //System.out.println(students[i][z]);
                }
            }
        }
    }
    
}

