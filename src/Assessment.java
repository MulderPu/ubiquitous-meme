import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project Name : Java Assignment 1
 * Created by Mulder on 4/13/2016.
 */
public class Assessment implements Serializable {

    private String name;
    private ArrayList<Submission> submissionsList = new ArrayList<>();
    private String weight;

    public Assessment(String name, String weight){
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public void printAssessmentDetails(){
        System.out.println("Name: " + getName() + "\n" + "Weight: " + getWeight() + "\n");
        System.out.println("List of submissions :");
        for(int i =0; i < submissionsList.size(); i++){
            System.out.println("\t" + i + "." + submissionsList.get(i).getName());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return ("Assessment Name:" + this.getName() + "\n" + "Weight :" + this.getWeight());
    }

    public void checkMark(int inputMark){


    }

    public void setSubmission(Submission submission){
        this.submissionsList.add(submission);
    }

    public ArrayList<Submission> getSubmissionsList() {
        return submissionsList;
    }

    public void removeSubmission(String inputStudName){
        for(int i =0; i < submissionsList.size(); i++){
            if(submissionsList.get(i).getName().equals(inputStudName)){
                this.submissionsList.remove(submissionsList.get(i));
            }
        }
    }
}
