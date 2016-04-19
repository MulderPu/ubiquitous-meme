import java.io.Serializable;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/19/2016.
 */
public class Submission implements Serializable {
    private String name;
    private String id;
    private double mark;

    public Submission(String name, String id){
        this.name = name;
        this.id = id;
        this.mark = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public String getId() {
        return id;
    }


}
