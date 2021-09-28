import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;  
import java.util.Arrays;
import java.util.*;

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
        String[] alphabetizeStudents = new String[countStudents];
        
        while(inputFileTwo.hasNextLine()){
            readStudents(inputFileTwo, students);
        }

        //System.out.println(Arrays.deepToString(students));

        averageTestGrade(students,avereageTestGrade);
        alphabetizeStudents(students, alphabetizeStudents);
    
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

    public static void averageTestGrade(String[][] students, double[] array){
        for(int i = 0; i < students.length -1; i++){
            double cal = 0;
            for(int z = 0; z < students[i].length -4; z++){
                cal += Integer.parseInt(students[i][z + 4]);
            }
            array[i] = cal/5;
        }
    }

    public static void alphabetizeStudents(String[][] students, String[] array){
        int length = 0;
        String temp; 
        String tempTwo;
        for(int i = 0; i < students.length -1; i++){
            //switched first and last name
            temp = students[i][0];
            students[i][0] = students[i][2];
            students[i][2] = temp;
            
            //switches middle and first name
            temp = students[i][2];
            students[i][2] = students[i][1];
            students[i][1] = temp;
            
        }
        
        for(int i = 0; i < students.length -1; i++){
            array[i] = students[i][2];
            length++;
        }
        Arrays.sort(array, 0, length);
        System.out.println(Arrays.deepToString(students));

        
        

        //System.out.println(Arrays.deepToString(array));
    }

    // public static void printStudents(String[][] students, String[] array){
    //     int count = 0; 
        
    //     while(count < array.length){
    //         for(int i = 0; i < students.length -1; i++){
    //             for(int z = 0; z < students[i].length; z++){
    //                 if(array[i].equals(students[i][0])){
    //                     System.out.println(array[i])
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
    // }
}

