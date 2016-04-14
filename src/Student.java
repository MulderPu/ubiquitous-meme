import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/28/2016.
 */
public class Student implements Serializable {

    private String name;
    private String id;
    private String program;
    ArrayList<Student> studentList = new ArrayList<>();

    public Student() {}

    public Student(String name, String id, String program){
        this.name = name;
        this.id = id;
        this.program = program;
    }

    public void add(){
        studentList.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void printStudentDetails(){
        System.out.println("Name :" + this.getName() + "\n"
                + "ID :" + this.getId() + "\n"
                + "Program Enrolled :" + this.getProgram() + "\n");
    }

    public void printStudentList(){
        for (int i = 0; i < studentList.size();i++){
            studentList.get(i).printStudentDetails();
        }
    }

    public void deleteStudent(String name){
        for(int i = 0; i<studentList.size(); i++){
            if(studentList.get(i).getName().equals(name)){
                studentList.remove(i);
            }
        }
    }

}
