import java.io.*;
import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/29/2016.
 */
public class Class implements Serializable{
    private String name;
    private String code;
    private Unit unit;
    private String sem;
    private int year;
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Assessment> assessmentList = new ArrayList<>();

    public Class(){}

    public Class(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void enrollStudent(Student student){
        this.studentList.add(student);
    }

    public void removeStudent(String studName){
        for(int i =0; i < studentList.size(); i++){
            if(studentList.get(i).getName().equals(studName)){
                this.studentList.remove(studentList.get(i));
            }
        }
    }

    public Unit getUnit() {
        return unit;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setAssessment(Assessment assessment){
        this.assessmentList.add(assessment);
    }

    public ArrayList<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void printClassDetails(){
        System.out.println("Class Name :" + this.getName() + "\n" + "Class Code :" + this.getCode());
        System.out.println(this.getUnit());

        System.out.println("List of assessments :");
        for(int i =0; i < assessmentList.size(); i++){
            System.out.println( i + "." + assessmentList.get(i).getName());
        }
        System.out.println();
        System.out.println("List of students :");
        for(int i =0; i < studentList.size(); i++){
            System.out.println("\t" + i + "." + studentList.get(i).getName());
        }
        System.out.println();
    }
}
