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
        double[] avereageTestGrade = new double[countStudents];
        
        while(inputFileTwo.hasNextLine()){
            readStudents(inputFileTwo, students);
        }

        for(int i = 0; i < students.length; i++){
            for(int z = 0; z < students[i].length; z++){
                System.out.println(students[0][z]);
            }
        }
        System.out.println(Arrays.deepToString(students));

        averageTestGrade(students,avereageTestGrade);
    }
    
    public static void readStudents(Scanner x, String[][] students){
        for(int i = 0; i < students.length -1; i++){
            for(int z = 0; z < students[i].length; z++){
                if(x.hasNextLine()){
                    students[i][z] = x.next();
                }
            }
        }
    }

    public static void averageTestGrade(String[][] x, double[] array){
        for(int i = 0; i < x.length -1; i++){
            double cal = 0;
            for(int z = 0; z < x[i].length -4; z++){
                cal += Integer.parseInt(x[i][z + 4]);
            }
            array[i] = cal/5; 
            System.out.println(array[i]);
        }
    }
    
}

