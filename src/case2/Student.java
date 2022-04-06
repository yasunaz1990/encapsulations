package case2;

public class Student {
    // --- Fields ----//
    public String fullName;
    public int    studentID;
    public double gpa;

    // --- Constructor ----//
    public Student(String name) {
        fullName = name;
        studentID = generateStudentId();
        gpa = 0.00;
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

    public int generateStudentId() {
        return (int)(Math.random() * 100000);
    }

    public void setGpa(double newGpa) {
        if(newGpa < 0 && newGpa > 4.0) {
            throw new IllegalArgumentException("Programming error: new gpa value is out of range..");
        }
        gpa = newGpa;
    }
}
