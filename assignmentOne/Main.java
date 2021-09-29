/*Christian koch
CSC112 Fall 2021
Programming Assignment 1
September 29, 2021 
This program reads a file and formats it in a specified way for output.
Make sure input.txt has no spaces and ends with the last students final test grade
*/


import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;  
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String [] args) throws IOException {
        PrintStream outputFile = new PrintStream(new File("output.txt"));

        FileInputStream fileByteStream = new FileInputStream("input.txt");
        Scanner inputFile = new Scanner(fileByteStream);

        FileInputStream fileByteStreamTwo = new FileInputStream("input.txt");
        Scanner inputFileTwo = new Scanner(fileByteStreamTwo);

        int countStudents = 0;
        int countInt = 0;

        //counts the number of lines in InputFile and gets the number of students
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
        
        //places students at every line into a 2d array 
        while(inputFileTwo.hasNextLine()){
            readStudents(inputFileTwo, students);
        }

        //calls of all functions 
        averageTestGrade(students,avereageTestGrade);
        alphabetizeStudents(students, alphabetizeStudents);
        printStudents(students, alphabetizeStudents, avereageTestGrade, countStudents, outputFile);
    
    }
    
    //places students into a 2d array 
    public static void readStudents(Scanner x, String[][] students){
        for(int i = 0; i < students.length -1; i++){
            for(int z = 0; z < students[i].length; z++){
                if(x.hasNextLine()){
                    students[i][z] = x.next();
                }
            }
        }
    }

    //caculates the test scores of every students and places them into an array 
    public static void averageTestGrade(String[][] students, double[] array){
        //transfer the average test scores into its own array 
        for(int i = 0; i < students.length -1; i++){
            double cal = 0;
            for(int z = 0; z < students[i].length -4; z++){
                cal += Integer.parseInt(students[i][z + 4]);
            }
            array[i] = cal/5;
        }
            
    }

    //alphabetizes the students 
    public static void alphabetizeStudents(String[][] students, String[] array){
        int length = 0;
        String temp; 
        for(int i = 0; i < students.length -1; i++){
            //switches first and last name
            temp = students[i][0];
            students[i][0] = students[i][2];
            students[i][2] = temp;
            
            //switches middle and first name
            temp = students[i][2];
            students[i][2] = students[i][1];
            students[i][1] = temp;
        }
        
        for(int i = 0; i < students.length -1; i++){
            array[i] = students[i][0];
            length++;
        }

        //sorts the array to find order of names
        Arrays.sort(array, 0, length);
    }

    //prints all wanted items 
    public static void printStudents(String[][] students, String[] array, double[] numArray, int numStudents, PrintStream outputFile){
        int count = 0; 
        //System.out.println(Arrays.deepToString(students));
        
        //prints n - 1 students in alphabetical order
        while(count < numStudents -1){
            //runs through the rows
            for(int i = 0; i < numStudents; i++){
                //checks last name follows order
                if(array[count].equals(students[i][0])){
                    //prints all componets of the student
                    for(int z = 0; z < students[i].length -5; z++){
                        System.setOut(outputFile);
                        System.out.print(students[i][z] + " ");
                    }
                    System.setOut(outputFile);
                    System.out.print(numArray[i]);
                    count++;

                    System.setOut(outputFile);
                    System.out.println("");
                }    
            }
        }

        //prints the final student
        for(int i = 0; i < students.length -1; i++){
            if(array[count].equals(students[i][0])){
                for(int z = 0; z < students[i].length -5; z++){
                    System.setOut(outputFile);
                    System.out.print(students[i][z] + " ");
                }
                System.setOut(outputFile);
                System.out.print(numArray[i]);
            }  
        }

        //prints the groups
        System.setOut(outputFile);
        System.out.println("\n");
        System.out.println("\n");
        System.out.print("Groups: ");
        System.out.println("\n");

        int groupCount = 0;
        int lastGroupCount = 0;
        int currentStudent = 0;
        int currentNumGroups = 0;
        int numMembersInGroup = 0;

        if(numStudents % 4 == 1){
            groupCount = numStudents/4 + 1 ;
            lastGroupCount = 5;
        }else if (numStudents % 4 == 0){
             groupCount = numStudents/4;
        }else if(numStudents % 4 != 0){
            groupCount = numStudents/4;
            lastGroupCount = numStudents % 4;
        }

        //first conditional to determine number of groups 
        if(numStudents % 4 == 0){
            double avgGrade = 0;

            //places students into group
            for(int i = 0; i < groupCount; i++){
                avgGrade = 0; 
                numMembersInGroup = 0;
                //runs through rows
                for(int row = 0; row < 4; row++){
                    //runs through col
                    for(int col = 0; col < students[row].length -8; col++){
                        //prints the students in each group 
                        System.setOut(outputFile);
                        System.out.println(students[currentStudent][col]);
                        avgGrade += numArray[currentStudent];
                    }
                    currentStudent++;
                    numMembersInGroup++;
                }
                currentNumGroups++;
                Random rand = new Random();
                int randInt = rand.nextInt(numMembersInGroup) +1;
    
                System.setOut(outputFile);
                System.out.print("Group " + currentNumGroups + " Leader: " + students[currentStudent - randInt][0] + "\n");
                System.out.println("Group Average Grade: " + avgGrade/numMembersInGroup + "\n");
            }
        }

        //second conditional to determine number of groups 
        if(numStudents % 4 != 0 && numStudents % 4 != 1){
            double avgGrade = 0;
            //places students into group
            for(int i = 0; i < groupCount; i++){
                avgGrade = 0; 
                numMembersInGroup = 0;
                //runs through rows
                for(int row = 0; row < 4; row++){
                    //runs through col
                    for(int col = 0; col < students[row].length -8; col++){
                        System.setOut(outputFile);
                        System.out.println(students[currentStudent][col]);
                        avgGrade += numArray[currentStudent];
                    }
                    currentStudent++;
                    numMembersInGroup++;
                }
                currentNumGroups++;
                
                Random rand = new Random();
                int randInt = rand.nextInt(numMembersInGroup +1);
    
                System.setOut(outputFile);
                System.out.print("Group " + currentNumGroups + " Leader: " + students[currentStudent - randInt][0] + "\n");
                System.out.println("Group Average Grade: " + avgGrade/numMembersInGroup + "\n");
            }

            numMembersInGroup = 0; 
            avgGrade = 0;
            if(currentStudent != numStudents){
                for(int row = 0; row < numStudents - currentStudent; row++){
                    //runs through col
                    for(int col = 0; col < students[row].length -8; col++){
                        System.setOut(outputFile);
                        System.out.println(students[currentStudent][col]);
                        avgGrade += numArray[currentStudent];
                    }
                    currentStudent++;
                    numMembersInGroup++;
                }
                currentNumGroups++;
                
                Random rand = new Random();
                int randInt = rand.nextInt(numMembersInGroup) +1;
    
                System.setOut(outputFile);
                System.out.print("Group " + currentNumGroups + " Leader: " + students[currentStudent - randInt][0] + "\n"); 
                System.out.println("Group Average Grade: " + avgGrade/numMembersInGroup + "\n");
            }
        }

        //final conditional to determine number of groups 
        if(numStudents % 4 == 1){
            double avgGrade = 0;

            //places students into group
            for(int i = 0; i < groupCount -1; i++){
                avgGrade = 0; 
                numMembersInGroup = 0;
                //runs through rows
                for(int row = 0; row < 4; row++){
                    //runs through col
                    for(int col = 0; col < students[row].length -8; col++){
                        System.setOut(outputFile);
                        System.out.println(students[currentStudent][col]);
                        avgGrade += numArray[currentStudent];
                    }

                    if(numStudents - currentStudent == 5){
                        currentStudent++;
                        for(int z = 0; z < students[row].length -8; z++){
                            System.setOut(outputFile);
                            System.out.println(students[currentStudent][z]);
                            avgGrade += numArray[currentStudent];
                        }
                        numMembersInGroup++;
                    }
                    currentStudent++;
                    numMembersInGroup++;
                }
                currentNumGroups++;
                Random rand = new Random();
                int randInt = rand.nextInt(numMembersInGroup) +1;
    
                System.setOut(outputFile);
                System.out.print("Group " + currentNumGroups + " Leader: " + students[currentStudent - randInt][0] + "\n");
                System.out.println("Group Average Grade: " + avgGrade/numMembersInGroup + "\n");
            }
        }
    }
}

