import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/13/2016.
 */
public class Assessment implements Serializable {

    private String name;
//    private ArrayList<Integer> mark = new ArrayList<>();
    private int mark;
    private String weight;

    public Assessment(String name, String weight){
        this.name = name;
        this.weight = weight;
        this.mark = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public int getMark() {
        return mark;
    }

    public void printAssessmentDetails(){
        System.out.println("Name: " + getName() + "\n" + "Weight: " + getWeight() + "\n");
    }

    @Override
    public String toString() {
        return ("Assessment Name:" + this.getName() + "\n" + "Weight :" + this.getWeight());
    }

    public void checkMark(int inputMark){


    }

}
