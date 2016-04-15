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
    static  ArrayList<Unit> unitList = new ArrayList<>();
    static  ArrayList<Class> classList = new ArrayList<>();
    static boolean loop = true;

    public static void main(String[] args) {
        homeMenu();
    }

    private static void homeMenu(){
        while(userInput != 5) {
            printHeader("HOME >>");
            System.out.println("1) Student Menu");
            System.out.println("2) Unit Menu");
            System.out.println("3) Class Menu");
            System.out.println("4) Assessment Menu");
            System.out.println("5) Exit Application");
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
                    unitMenu();
                    break;
                case 3:
                    classMenu();
                    break;
                case 4:
                    assessmentMenu();
                    break;
                case 5:
                    //Program Exit Point
                    break;
                default:
                    System.out.println("Invalid Input.");
                    System.out.println("Please re-enter a correct format.");
            }
        }
        System.out.println("Bye Bye");
    }

    private static void assessmentMenu() {
        while(userInput != 0)
        {
            printHeader("HOME >> ASSESSMENT MENU");
            System.out.println("1) Create Assessment");
            System.out.println("2) View Assessment");
            System.out.println("3) Edit Assessment");
            System.out.println("4) Delete Assessment");
            System.out.println("0) Back");
            System.out.println();
            System.out.println("Select number: ");

            try{
                userInput = input.nextInt();
                input.nextLine();
            }catch(Exception e)
            {
                input.nextLine();
                System.out.println(e);
            }

            switch(userInput)
            {
                case 1:
                    createAssessment();
                    break;
                case 2:
//                    viewAssessment();
                    break;
                case 3:
//                    editAssessment();
                    break;
                case 4:
//                    deleteAssessment();
                    break;
                case 0:
                    //Back Point
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void createAssessment() {

    }

    private static void classMenu() {
        while(userInput != 0)
        {
            printHeader("HOME >> CLASS MENU");
            System.out.println("1) Create Class");
            System.out.println("2) View Class");
            System.out.println("3) Edit Class");
            System.out.println("4) Delete Class");
            System.out.println("5) Add Unit to Class");
            System.out.println("6) Add Student to Class");
            System.out.println("7) Add Assessment to Class");
            System.out.println("0) Back");
            System.out.println();
            System.out.println("Select number: ");

            try{
                userInput = input.nextInt();
                input.nextLine();
            }catch(Exception e)
            {
                input.nextLine();
                System.out.println(e);
            }

            switch(userInput)
            {
                case 1:
                    createClass();
                    break;
                case 2:
                    viewClass();
                    break;
                case 3:
                    editClass();
                    break;
                case 4:
                    deleteClass();
                    break;
                case 5:
                    addUnitToClass();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 0:
                    //Back Point
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void addUnitToClass() {
        readClassFile();
        readUnitFile();

        while(loop){
            System.out.println("Enter class name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < classList.size(); i++) {
                if (classList.get(i).getName().equals(inputName)) {
                    classList.get(i).printClassDetails();
                }
            }

            System.out.println("Confirm add unit to this class? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                System.out.println("============================================================");
                System.out.println("Lists of units");
                System.out.println("============================================================");

                //loop for unit list
                for (int i = 0; i < unitList.size(); i++) {
                    System.out.println(i + "." + unitList.get(i).getName());
                }

                System.out.println("Enter unit name you wish to add:");
                String inputUnit = input.nextLine();

                for (int i = 0; i < unitList.size(); i++) {
                    if(unitList.get(i).getName().equals(inputUnit)){
                        for (int j = 0; j < classList.size(); j++) {
                            if (classList.get(j).getName().equals(inputName)) {
                                classList.get(j).setUnitName(unitList.get(i).getName());
                                classList.get(j).setUnitCode(unitList.get(i).getCode());
                            }
                        }
                    }
                }
            }

            System.out.println("Class had been updated.");
            //re-write class file for the changes made
            writeClassFile();

            System.out.println("Do you want to exit? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }

    }

    private static void deleteClass() {
        //read class file and store in arraylist
        readClassFile();

        while (loop){
            System.out.println("Enter class name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < classList.size(); i++) {
                if (classList.get(i).getName().equals(inputName)) {
                    classList.get(i).printClassDetails();
                }
            }

            System.out.println("Confirm delete class? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                System.out.println("Enter class name again: ");
                String className = input.nextLine();
                System.out.println("Enter class code : ");
                String classCode = input.nextLine();

                for (int i = 0; i < classList.size(); i++) {
                    if (classList.get(i).getName().equals(className) && classList.get(i).getCode().equals(classCode)) {
                        classList.remove(i);
                        System.out.println("Class had been removed.");
                    }
                }
            }

            //re-write class file for the changes made
            writeClassFile();

            System.out.println("Do you want to continue delete class? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    private static void editClass() {
        //read class file and store in arraylist
        readClassFile();

        while(loop) {
            System.out.println("Enter class name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < classList.size(); i++) {
                if (classList.get(i).getName().equals(inputName)) {
                    classList.get(i).printClassDetails();
                }
            }

            System.out.println("Confirm edit this class? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                int cont = 0;
                while (cont != 3) {
                    System.out.println("============================================================");
                    System.out.println("1) Edit Name");
                    System.out.println("2) Edit Code");
                    System.out.println("3) Back");
                    System.out.println();
                    System.out.println("Select number: ");

                    try {
                        cont = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println(e);
                    }

                    switch (cont) {
                        case 1:
                            System.out.println("============================================================");
                            System.out.println("Old Name: ");
                            String oldName = input.nextLine();
                            System.out.println("New Name: ");
                            String newName = input.nextLine();
                            for (int i = 0; i < classList.size(); i++) {
                                if (classList.get(i).getName().equals(oldName)) {
                                    classList.get(i).setName(newName);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("============================================================");
                            System.out.println("Old Code: ");
                            String oldCode = input.nextLine();
                            System.out.println("New Code: ");
                            String newCode = input.nextLine();
                            for (int i = 0; i < classList.size(); i++) {
                                if (classList.get(i).getCode().equals(oldCode)) {
                                    classList.get(i).setCode(newCode);
                                }
                            }
                            break;
                        case 3:
                            //Back Point
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                }
            }
            System.out.println("Class had been updated.");
            //re-write class file for the changes made
            writeClassFile();

            System.out.println("Do you want to continue edit class? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    private static void viewClass() {
        //read file and store in arraylist
        readClassFile();

        while(loop){
            System.out.println("============================================================");
            System.out.println("Lists of classes");
            System.out.println("============================================================");

            //loop for class list
            for (int i = 0; i < classList.size(); i++) {
                System.out.println(i + "." + classList.get(i).getName());
            }

            //show specific unit details
            System.out.println("Enter class name for more info: ['exit' to back]");
            String inputName = input.nextLine();

            if (inputName.equals("exit")) {
                break;
            } else {
                System.out.println("============================================================");
                System.out.println("Class info");
                System.out.println("============================================================");
                for (int i = 0; i < classList.size(); i++) {
                    if (classList.get(i).getName().equals(inputName)) {
                        classList.get(i).printClassDetails();
                    }
                }
                pressEnterKeyToContinue();
            }
        }
    }

    private static void createClass() {
        //read file and store in arraylist
        readClassFile();

        while(loop) {
            System.out.println("Do you wish to create a class? [y/n]");
            String ans = input.next();
            input.nextLine();

            if(ans.equals("n")){
                break;
            }

            System.out.println("Please enter the class information:");
            System.out.println("Name :");
            String inputName = input.nextLine();
            System.out.println("Code :");
            String inputCode = input.nextLine();

            //create class, add to arraylist
            Class newClass = new Class(inputName, inputCode);

            if (!inputName.equals("") || !inputCode.equals("")) {
                classList.add(newClass);
            }

            //store arraylist in txt file
            writeClassFile();

            System.out.println("Class had been created.");
            System.out.println("Do you want to continue create class? [y/n]");
            String result = input.next();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    private static void unitMenu() {
        while(userInput != 0)
        {
            printHeader("HOME >> UNIT MENU");
            System.out.println("1) Create Unit");
            System.out.println("2) View Unit");
            System.out.println("3) Edit Unit");
            System.out.println("4) Delete Unit");
            System.out.println("0) Back");
            System.out.println();
            System.out.println("Select number: ");

            try{
                userInput = input.nextInt();
                input.nextLine();
            }catch(Exception e)
            {
                input.nextLine();
                System.out.println(e);
            }

            switch(userInput)
            {
                case 1:
                    createUnit();
                    break;
                case 2:
                    viewUnit();
                    break;
                case 3:
                    editUnit();
                    break;
                case 4:
                    deleteUnit();
                    break;
                case 0:
                    //Back Point
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void deleteUnit() {
        //read unit file and store in arraylist
        readUnitFile();

        while (loop){
            System.out.println("Enter unit name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < unitList.size(); i++) {
                if (unitList.get(i).getName().equals(inputName)) {
                    unitList.get(i).printUnitDetails();
                }
            }

            System.out.println("Confirm delete unit? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                System.out.println("Enter unit name again: ");
                String unitName = input.nextLine();
                System.out.println("Enter unit code : ");
                String unitCode = input.nextLine();

                for (int i = 0; i < unitList.size(); i++) {
                    if (unitList.get(i).getName().equals(unitName) && unitList.get(i).getCode().equals(unitCode)) {
                        unitList.remove(i);
                        System.out.println("Unit had been removed.");
                    }
                }
            }

            //re-write unit file for the changes made
            writeUnitFile();

            System.out.println("Do you want to continue delete unit? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    private static void editUnit() {
        //read unit file and store in arraylist
        readUnitFile();

        while(loop) {
            System.out.println("Enter unit name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < unitList.size(); i++) {
                if (unitList.get(i).getName().equals(inputName)) {
                    unitList.get(i).printUnitDetails();
                }
            }

            System.out.println("Confirm edit this unit? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                int cont = 0;
                while (cont != 3) {
                    System.out.println("============================================================");
                    System.out.println("1) Edit Name");
                    System.out.println("2) Edit Code");
                    System.out.println("3) Back");
                    System.out.println();
                    System.out.println("Select number: ");

                    try {
                        cont = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println(e);
                    }

                    switch (cont) {
                        case 1:
                            System.out.println("============================================================");
                            System.out.println("Old Name: ");
                            String oldName = input.nextLine();
                            System.out.println("New Name: ");
                            String newName = input.nextLine();
                            for (int i = 0; i < unitList.size(); i++) {
                                if (unitList.get(i).getName().equals(oldName)) {
                                    unitList.get(i).setName(newName);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("============================================================");
                            System.out.println("Old Code: ");
                            String oldCode = input.nextLine();
                            System.out.println("New Code: ");
                            String newCode = input.nextLine();
                            for (int i = 0; i < unitList.size(); i++) {
                                if (unitList.get(i).getCode().equals(oldCode)) {
                                    unitList.get(i).setCode(newCode);
                                }
                            }
                            break;
                        case 3:
                            //Back Point
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                }
            }
            System.out.println("Unit had been updated.");
            //re-write unit file for the changes made
            writeUnitFile();

            System.out.println("Do you want to continue edit unit? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    private static void viewUnit() {
        //read file and store in arraylist
        readUnitFile();

        while(loop){
            System.out.println("============================================================");
            System.out.println("Lists of units");
            System.out.println("============================================================");

            //loop for unit list
            for (int i = 0; i < unitList.size(); i++) {
                System.out.println(i + "." + unitList.get(i).getName());
            }

            //show specific unit details
            System.out.println("Enter unit name for more info: ['exit' to back]");
            String inputName = input.nextLine();

            if (inputName.equals("exit")) {
                break;
            } else {

                System.out.println("============================================================");
                System.out.println("Unit info");
                System.out.println("============================================================");
                for (int i = 0; i < unitList.size(); i++) {
                    if (unitList.get(i).getName().equals(inputName)) {
                        unitList.get(i).printUnitDetails();
                    }
                }
                pressEnterKeyToContinue();
            }
        }
    }

    private static void createUnit() {
        //read file and store in arraylist
        readUnitFile();

        while(loop) {
            System.out.println("Do you wish to create a unit? [y/n]");
            String ans = input.next();
            input.nextLine();

            if(ans.equals("n")){
                break;
            }

            System.out.println("Please enter the unit information:");
            System.out.println("Name :");
            String inputName = input.nextLine();
            System.out.println("Code :");
            String inputCode = input.nextLine();

            //create unit, add to arraylist
            Unit newUnit = new Unit(inputName, inputCode);

            if (!inputName.equals("") || !inputCode.equals("")) {
                unitList.add(newUnit);
            }

            //store arraylist in txt file
            writeUnitFile();

            System.out.println("Unit had been created.");
            System.out.println("Do you want to continue create unit? [y/n]");
            String result = input.next();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
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
                input.nextLine();
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
        //read student file and store in arraylist
        readStudentFile();

        while (loop){
            System.out.println("Enter student name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getName().equals(inputName)) {
                    studentList.get(i).printStudentDetails();
                }
            }

            System.out.println("Confirm delete? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                System.out.println("Enter student name again: ");
                String StudName = input.nextLine();
                System.out.println("Enter student Id : ");
                String StudId = input.nextLine();

                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getName().equals(StudName) && studentList.get(i).getId().equals(StudId)) {
                        studentList.remove(i);
                        System.out.println("Student had been removed.");
                    }
                }
            }

            //re-write student file for the changes made
            writeStudentFile();

            System.out.println("Do you want to continue delete student? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

    private static void editStudent() {
        //read student file and store in arraylist
        readStudentFile();

        while(loop) {
            System.out.println("Enter student name: ");
            String inputName = input.nextLine();

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getName().equals(inputName)) {
                    studentList.get(i).printStudentDetails();
                }
            }

            System.out.println("Confirm edit this student? [y/n] ");
            String ans = input.next();
            input.nextLine();

            if (ans.equals("y")){
                int cont = 0;
                while (cont != 4) {
                    System.out.println("============================================================");
                    System.out.println("1) Edit Name");
                    System.out.println("2) Edit ID");
                    System.out.println("3) Edit Program Enrolled");
                    System.out.println("4) Back");
                    System.out.println();
                    System.out.println("Select number: ");

                    try {
                        cont = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println(e);
                    }

                    switch (cont) {
                        case 1:
                            System.out.println("============================================================");
                            System.out.println("Old Name: ");
                            String oldName = input.nextLine();
                            System.out.println("New Name: ");
                            String newName = input.nextLine();
                            for (int i = 0; i < studentList.size(); i++) {
                                if (studentList.get(i).getName().equals(oldName)) {
                                    studentList.get(i).setName(newName);
                                }
                            }
                            break;
                        case 2:
                            System.out.println("============================================================");
                            System.out.println("Old ID: ");
                            String oldId = input.nextLine();
                            System.out.println("New ID: ");
                            String newId = input.nextLine();
                            for (int i = 0; i < studentList.size(); i++) {
                                if (studentList.get(i).getId().equals(oldId)) {
                                    studentList.get(i).setId(newId);
                                }
                            }
                            break;
                        case 3:
                            System.out.println("============================================================");
                            System.out.println("Old Program: ");
                            String oldProgram = input.nextLine();
                            System.out.println("New Program: ");
                            String newProgram = input.nextLine();
                            for (int i = 0; i < studentList.size(); i++) {
                                if (studentList.get(i).getProgram().equals(oldProgram)) {
                                    studentList.get(i).setProgram(newProgram);
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
            }
            System.out.println("Student had been updated.");
            //re-write student file for the changes made
            writeStudentFile();

            System.out.println("Do you want to continue edit student? [y/n]");
            String result = input.next();
            input.nextLine();

            if(result.equals("n")){
                break;
            }
            else{
                loop=true;
            }
        }
    }

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
            System.out.println("Enter student name for more info: ['exit' to back]");
            String inputName = input.nextLine();

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

    private static void createStudent() {

        //read file and store in arraylist
        readStudentFile();

        while(loop) {
            System.out.println("Do you wish to create a student? [y/n]");
            String ans = input.next();
            input.nextLine();

            if(ans.equals("n")){
                break;
            }

            System.out.println("Please enter the student information:");
            System.out.println("Name :");
            String inputName = input.nextLine();
            System.out.println("ID :");
            String inputId = input.nextLine();
            System.out.println("Program Enrolled: ");
            String inputProgram = input.nextLine();

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
            input.nextLine();

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
        } catch (Exception e) {
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

    //read unit file
    private static void readUnitFile(){
        try {
            FileInputStream fis2 = new FileInputStream("unit.txt");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            unitList = (ArrayList) ois2.readObject();
            ois2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //write unit file
    private static void writeUnitFile(){
        try {
            FileOutputStream fos2 = new FileOutputStream("unit.txt");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos2.writeObject(unitList);
            oos2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //read class file
    private static void readClassFile(){
        try {
            FileInputStream fis3 = new FileInputStream("class.txt");
            ObjectInputStream ois3 = new ObjectInputStream(fis3);
            classList = (ArrayList) ois3.readObject();
            ois3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //write class file
    private static void writeClassFile(){
        try {
            FileOutputStream fos3 = new FileOutputStream("class.txt");
            ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
            oos3.writeObject(classList);
            oos3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
