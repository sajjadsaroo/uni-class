package uni;
import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade) {
        transcript.put(presentedCourseID, grade);
    }

    public void printTranscript() {

        if(Person.findByID(studentID) != null && Student.findById(studentID) != null) {
            System.out.println("Transcript for Student name: " + Person.findByID(studentID).name + " StudentId: " + Student.findById(studentID).studentID);
            for (Integer courseID : transcript.keySet()) {
                if(Course.findById(courseID) != null){
                    System.out.println(" Course Name: " + Course.findById(courseID).title + "- Course ID: " + courseID + " - Grade: " + transcript.get(courseID));
                }
            }
            System.out.println();
        }

    }


}
