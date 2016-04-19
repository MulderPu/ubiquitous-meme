/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/14/2016.
 */
public class Assignment extends Assessment {
    public Assignment(String name, String weight){
        super(name, weight);
    }

    @Override
    public String toString() {
        return ("Assignment Name:" + this.getName() + "\n" + "Weight :" + this.getWeight());
    }

}
