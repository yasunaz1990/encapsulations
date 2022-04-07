package case2;

public class Student {
    // --- Fields ----//
    private String fullName;
    private int    studentID;
    private double gpa;

    // --- Constructor ----//
    public Student(String name, double d) {
        fullName = name;
        studentID = generateStudentId();
        gpa = d;
    }

    //--Setters & Getters--//
    public void setFullName(String newFullName) {
        if(newFullName.contains("Joker")) {
            throw new IllegalArgumentException("Programming error: the name cannot contain Joker");
        }
        fullName = newFullName;
    }

    public int getStudentID() {
        return studentID%100;
    }

    public void setGpa(double newGpa) {
        if(newGpa < 0 || newGpa > 4.0) {
            throw new IllegalArgumentException("Programming error: new gpa value is out of range...");
        }
        gpa = newGpa;
    }

    // --- Methods ----//
    public void showObjectState() {
        System.out.println("=====OBJECT======");
        System.out.println("Object Address: " + this);
        System.out.println("--FIELD ---");
        System.out.println("fullName  : " + fullName);
        System.out.println("studentID : " + studentID);
        System.out.println("gpa   : " + gpa);
        System.out.println("--METHOD---");
        System.out.println("showObjectState()");
        System.out.println("printStudentInfo()");
        System.out.println("generateStudentId()");
        System.out.println("setGpa()");
        System.out.println("================\n");
    }

    public void printStudentInfo() {
        System.out.println("Student name: " + fullName);
        System.out.println("Student Id  : " + studentID);
        System.out.println("Student GPA : " + gpa);
    }

    // Helper method
    private int generateStudentId() {
        return (int)(Math.random() * 100000);
    }
}
