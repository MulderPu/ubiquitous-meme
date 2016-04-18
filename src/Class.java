import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/29/2016.
 */
public class Class implements Serializable{
    private String name;
    private String code;
    private Unit unit;
    private ArrayList<Student> studentList = new ArrayList<>();
    private Assessment assessment;

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

    public void getStudentList() {
        for(int i =0; i < studentList.size(); i++){
            System.out.println( i + "." + studentList.get(i).getName());
        }
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setAssessment(Assessment assessment){
        this.assessment = assessment;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void printClassDetails(){
        System.out.println("Class Name :" + this.getName() + "\n" + "Class Code :" + this.getCode());
        System.out.println(this.getUnit());
        System.out.println(this.getAssessment());
        System.out.println("List of students :" + "\n");
        for(int i =0; i < studentList.size(); i++){
            System.out.println("\t" + i + "." + studentList.get(i).getName());
        }
    }
}
