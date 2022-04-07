package case2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Prompt & Process
        System.out.println("Welcome George Mason University Staff!");
        System.out.println("Please enter student info for registration");
        System.out.println("-------------------------------------");

        System.out.print("Student Full Name: ");
        String nameInput = scan.nextLine();

        System.out.print("Student Initial GPA: ");
        double gpaThisYear = scan.nextDouble();

        // rep of student
        Student object = new Student(nameInput, gpaThisYear); // rep of student
        object.showObjectState();
        object.setGpa(1.2);
        object.setFullName("John Kelly");
        System.out.println("***" + object.getStudentID());
        object.showObjectState();

    }
}
