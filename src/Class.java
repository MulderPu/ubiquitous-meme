import java.io.Serializable;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/29/2016.
 */
public class Class implements Serializable{
    public String name;
    public String code;

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

    public void enrollStudent(){

    }

    public void removeStudent(){

    }

    public void addUnit(){

    }

    public void addAssessment(){

    }

    public void printClassDetails(){
        System.out.println("Class Name :" + this.getName() + "\n" + "Class Code :" + this.getCode() + "\n");

    }
}
