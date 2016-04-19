/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/14/2016.
 */
public class Test extends Assessment {
    public Test(String name, String weight){
        super(name, weight);
    }

    @Override
    public String toString() {
        return ("Test Name:" + this.getName() + "\n" + "Weight :" + this.getWeight());
    }
}
