import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 3/29/2016.
 */
public class Unit {
    private String name;
    private String code;

    public Unit(){
        this.name = "";
        this.code = "";
    }

    public Unit(String name, String code){
        this.name = name;
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void printUnitDetails(){
        System.out.println("Unit :" + this.getName() + "\n" + "Unit Code :" + this.getCode());
    }

    public  void addAssessment(){

    }
}