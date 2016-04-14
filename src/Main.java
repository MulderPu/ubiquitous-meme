import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/28/2016.
 */
public class Main implements Serializable {
    static Scanner input = new Scanner(System.in);
    static int userInput;
    static  ArrayList<Student> studentList = new ArrayList<>();
    static boolean loop = true;
    static boolean loop2 = true;

    public static void main(String[] args) {
        homeMenu();
    }

    private static void homeMenu(){
        while(userInput != 4) {
            printHeader("HOME >>");
            System.out.println("1) Student Menu");
            System.out.println("2) Unit Menu");
            System.out.println("3) Class Menu");
            System.out.println("4) Exit");
            System.out.println();
            System.out.println("Select number: ");

            try{
                userInput = input.nextInt();
            }catch(Exception e)
            {
                input.nextLine();
                System.out.println(e);
            }

            switch(userInput) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    //Program Exit Point
                    break;
                default:
                    System.out.println("Invalid Input.");
                    System.out.println("Please re-enter a correct format.");
            }
        }
        System.out.println("Bye Bye");
    }

    private static void studentMenu() {
        while(userInput != 0)
        {
            printHeader("HOME >> STUDENT MENU");
            System.out.println("1) Create Student");
            System.out.println("2) View Student");
            System.out.println("3) Edit Student");
            System.out.println("4) Delete Student");
            System.out.println("0) Back");
            System.out.println();
            System.out.println("Select number: ");

            try{
                userInput = input.nextInt();
            }catch(Exception e)
            {
                input.nextLine();
                System.out.println(e);
            }

            switch(userInput)
            {
                case 1:
                    createStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 0:
                    //Back Point
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void deleteStudent() {
        int exist = 1;
        //read student file and store in arraylist
        readStudentFile();

        while (loop){
            System.out.println("Enter student name: ");
            String inputName = input.next();

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getName().equals(inputName)) {
                    studentList.get(i).printStudentDetails();
                    exist =1;
                }
                else{
                    exist = 0;
                }
            }

            if(exist ==1){
                System.out.println("Confirm delete? [y/n] ");
                String ans = input.next();

                if (ans.equals("y")){
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getName().equals(inputName)) {
                            studentList.remove(i);
                        }
                    }
                }

                //re-write student file for the changes made
                writeStudentFile();
            }
            else{
                System.out.println("Student not exist.");
            }

            System.out.println("Do you want to continue delete student? [y/n]");
            String result = input.next();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    //edit student based on name
    private static void editStudent() {
        int cont = 0;
        int exist = 1;
        //read student file and store in arraylist
        readStudentFile();

        while(loop) {
            System.out.println("Enter student name: ");
            String inputName = input.next();

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getName().equals(inputName)) {
                    studentList.get(i).printStudentDetails();
                    exist =1;
                }
                else{
                    exist = 0;
                }
            }

            if(exist == 1) {
                while (cont != 4) {
                    System.out.println("1) Edit Name");
                    System.out.println("2) Edit ID");
                    System.out.println("3) Edit Program Enrolled");
                    System.out.println("4) Exit");
                    System.out.println();
                    System.out.println("Select number: ");

                    try {
                        cont = input.nextInt();
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println(e);
                    }

                    switch (cont) {
                        case 1:
                            System.out.println("Old Name: ");
                            String oldName = input.next();
                            System.out.println("New Name: ");
                            String newName = input.next();
                            for (int i = 0; i < studentList.size(); i++) {
                                if (studentList.get(i).getName().equals(oldName)) {
                                    studentList.get(i).setName(newName);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Old ID: ");
                            String oldId = input.next();
                            System.out.println("New ID: ");
                            String newId = input.next();
                            for (int i = 0; i < studentList.size(); i++) {
                                if (studentList.get(i).getId().equals(oldId)) {
                                    studentList.get(i).setId(newId);
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Old Program: ");
                            String oldProgram = input.next();
                            System.out.println("New Program: ");
                            String newProgram = input.next();
                            for (int i = 0; i < studentList.size(); i++) {
                                if (studentList.get(i).getId().equals(oldProgram)) {
                                    studentList.get(i).setId(newProgram);
                                }
                            }
                            break;
                        case 4:
                            //Back Point
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                }

                //re-write student file for changes
                writeStudentFile();
                System.out.println("Student had been edited.");
            }
            else{
                System.out.println("Student not exist.");
            }

            System.out.println("Do you want to continue edit student? [y/n]");
            String result = input.next();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    //view list of student and details
    private static void viewStudent() {
        //read file and store in arraylist
        readStudentFile();

        while(loop){
            System.out.println("============================================================");
            System.out.println("Lists of students");
            System.out.println("============================================================");

            //loop for student list
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(i + "." + studentList.get(i).getName());
            }

            //show specific student details
            System.out.println("Enter student name for more info: ['exit' to quit]");
            String inputName = input.next();

            if (inputName.equals("exit")) {
                break;
            } else {

                System.out.println("============================================================");
                System.out.println("Student info");
                System.out.println("============================================================");
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getName().equals(inputName)) {
                        studentList.get(i).printStudentDetails();
                    }
                }
                pressEnterKeyToContinue();
            }
        }
    }

    //create student and add to arraylist
    private static void createStudent() {
        //read file and store in arraylist
        readStudentFile();

        while(loop) {
            System.out.println("Do you wish to create a student? [y/n]");
            String ans = input.next();

            if(ans.equals("n")){
                break;
            }

            System.out.println("Please enter the student information:");
            System.out.println("Name :");
            String inputName = input.next();
            System.out.println("ID :");
            String inputId = input.next();
            System.out.println("Program Enrolled: ");
            String inputProgram = input.next();

            //create student, add to arraylist
            Student newStudent = new Student(inputName, inputId, inputProgram);

            if (!inputName.equals("") || !inputId.equals("") || !inputProgram.equals("")) {
                studentList.add(newStudent);
            }

            //store arraylist in txt file
            writeStudentFile();

            System.out.println("Student had been created.");
            System.out.println("Do you want to continue create student? [y/n]");
            String result = input.next();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    //print header of console application
    private static void printHeader(String title) {
        System.out.println("============================================================");
        System.out.println("Student Management Application");
        System.out.println("============================================================");
        System.out.println(title);
        System.out.println();
    }

    //press enter to continue, PAUSE
    private static void pressEnterKeyToContinue()
    {
        System.out.println("Press enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    //read student file
    private static void readStudentFile(){
        try {
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (ArrayList) ois.readObject();
            ois.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //write student file
    private static void writeStudentFile(){
        try {
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}