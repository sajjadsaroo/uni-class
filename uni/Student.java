package uni;

import java.util.ArrayList;

public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public int personId;
    public final int entranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID) {
        if (Major.findById(majorID) != null) {
            this.entranceYear = entranceYear;
            this.majorID = majorID;
            this.personId = personID;
            Major major = Major.findById(this.majorID);
            major.numberOfStudents++;
            this.id = studentList.size() + 1;
            studentList.add(this);
            setStudentCode();
        } else {
            this.entranceYear = 0;
        }
    }

    public static Student findById(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }


}
