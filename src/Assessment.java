/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/13/2016.
 */
public class Assessment {

    private String name;
    private int mark;
    String weight; // can be change

    public Assessment(){

    }

    public Assessment(String name, int mark){
        this.mark = mark;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}
