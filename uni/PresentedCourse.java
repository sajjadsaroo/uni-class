package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<PresentedCourse>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds;

    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        this.id = presentedCourseList.size() + 1;
        this.studentIds = new ArrayList<Integer>(maxCapacity);
        presentedCourseList.add(this);
    }

    public static PresentedCourse findById(int ID) {
        for(PresentedCourse c : presentedCourseList) {
            if(c.id == ID) {
                return c;
            }
        }
        return null;
    }


}
