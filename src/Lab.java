

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/14/2016.
 */
public class Lab extends Assessment{;

    public Lab(String name, String weight){
        super(name, weight);
    }

    @Override
    public String toString() {
        return ("Lab Name:" + this.getName() + "\n" + "Weight :" + this.getWeight());
    }

}
