import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/29/2016.
 */
public class Class implements Serializable{
    private String name;
    private String code;
    private String unitName;
    private String unitCode;
    private ArrayList<Student> studentList = new ArrayList<>();
    private Assessment assessment;

    public Class(){}

    public Class(String name, String code){
        this.name = name;
        this.code = code;
        this.unitName = "";
        this.unitCode = "";
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

    public void removeStudent(Student student){
       this.studentList.remove(student);
    }

    public String getStudentList() {
        for(int i =0; i < studentList.size(); i++){
            return studentList.get(i).getName();
        }
        return null;
    }

    public void setUnitName(String unitName ){
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void printStudentListDetail(){
        for(int i =0; i < studentList.size(); i++){
            System.out.println(studentList.get(i).getName());
        }
    }

    public void setAssessment(Assessment assessment){
        this.assessment = assessment;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void printClassDetails(){
        System.out.println("Class Name :" + this.getName() + "\n" + "Class Code :" + this.getCode() + "\n"
                            + "Unit Name: " + this.getUnitName() + "\n"
                            + "Unit Code: " + this.getUnitCode() + "\n"
                            +"List of students: " + getStudentList() + "\n");
    }
}
