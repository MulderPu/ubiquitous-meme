/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/13/2016.
 */
public class Semester {
    private String name;

    public Semester(){

    }

    public Semester(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printSemDetails(){
        System.out.println("Semester :" + getName());
    }


}
