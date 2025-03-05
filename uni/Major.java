package uni;

import java.util.ArrayList;

public class Major {
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<Major>();
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;

    public Major(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
        this.id = majorList.size() + 1;
        majorList.add(this);
    }

    public static Major findById(int id) {
        for (Major m : majorList) {
            if (m.id == id) {
                return m;
            }
        }
        return null;
    }

    public void addStudent() {
        if (numberOfStudents >= capacity) {
            System.out.println("Maximum capacity exceeded");
        } else {
            this.numberOfStudents++;
        }
    }
}
