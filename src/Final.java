/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/14/2016.
 */
public class Final extends Assessment {
    public Final(String name, String weight){
        super(name, weight);
    }

    @Override
    public String toString() {
        return ("Final Name:" + this.getName() + "\n" + "Weight :" + this.getWeight());
    }
}
