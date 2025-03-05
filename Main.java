import base.*;
import uni.*;


public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ali Ahmadi", "1234567890");
        Person p2 = new Person("Sara Karimi", "0987654321");
        Person p3 = new Person("Reza Mohammadi", "1122334455");
        Person p4 = new Person("Neda Hosseini", "2233445566");
        Person p5 = new Person("Hassan Ramezani", "3344556677");

        Major cs = new Major("Computer Science", 50);
        Major math = new Major("Mathematics", 40);

        Student s1 = new Student(p1.id, 401, cs.id);
        Student s2 = new Student(p2.id, 401, cs.id);
        Student s3 = new Student(p5.id, 403, math.id);

        System.out.println("Students List:");
        for (Student s : Student.studentList) {
            Person person = Person.findByID(s.personId);
            if (person != null) {
                System.out.println("Student ID: " + s.studentID + ", Name: " + person.name);
            } else {
                System.out.println("Student ID: " + s.studentID + " -> Person not found!");
            }
        }

        Professor prof1 = new Professor(p4.id, cs.id);
        Professor prof2 = new Professor(p3.id, math.id);

        System.out.println("\nProfessors List:");
        for (Professor prof : Professor.professorList) {
            Person person = Person.findByID(prof.personID);
            if (person != null) {
                System.out.println("Professor ID: " + prof.id + ", Name: " + person.name);
            } else {
                System.out.println("Professor ID: " + prof.id + " -> Person not found!");
            }
        }

        Course course1 = new Course("Programming", 3);
        Course course2 = new Course("Calculus", 4);
        Course course3 = new Course("Algorithms", 3);

        PresentedCourse pc1 = new PresentedCourse(course1.id, prof1.id, 30);
        PresentedCourse pc2 = new PresentedCourse(course2.id, prof1.id, 25);
        PresentedCourse pc3 = new PresentedCourse(course3.id, prof2.id, 20);

        pc1.addStudent(s1.id);
        pc1.addStudent(s2.id);

        pc2.addStudent(s1.id);
        pc2.addStudent(s2.id);
        pc2.addStudent(s3.id);

        pc3.addStudent(s3.id);

        System.out.println("\nRegistered Students for Courses:");
        for (PresentedCourse pc : PresentedCourse.presentedCourseList) {
            Course course = Course.findById(pc.courseID);
            String courseTitle = (course != null ? course.title : "Unknown Course");
            System.out.println("Course: " + courseTitle);
            for (int studentId : pc.studentIds) {
                Student st = Student.findById(studentId);
                if (st != null) {
                    Person studentPerson = Person.findByID(st.personId);
                    System.out.println("  - " + (studentPerson != null ? studentPerson.name : "Unknown Student"));
                }
            }
        }

    }
}
