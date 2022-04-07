package case1;

import java.util.Date;

public class Book {
    //--Field--//
    private String title;
    private String author;
    private int    isbn;
    private String registrationDate;


    //--Constructor--//
    public Book() {
        title = "";
        author ="";
        isbn = generateISBN();
        registrationDate = getRegistrationDateTimeStamp();
    }

    public Book(String t, String a) {
        title =  t;
        author = a;
        isbn = generateISBN();
        registrationDate = getRegistrationDateTimeStamp();
    }

    //--Setters & Getters--//
    public void setTitle(String newTitle) {
        if(newTitle.contains("%")) {
            throw new IllegalArgumentException("Programming error");
        }
        title = newTitle;
    }

    public String getIsbn() {
        return "***" + isbn%100;
    }


    //--Methods--//
    public void showObjectState() {
        System.out.println("=====OBJECT======");
        System.out.println("Object Address: " + this);
        System.out.println("--FIELD ---");
        System.out.println("title  : " + title);
        System.out.println("author : " + author);
        System.out.println("--METHOD---");
        System.out.println("showObjectState()");
        System.out.println("printBookInfo()");
        System.out.println("generateISBN()");
        System.out.println("getRegistrationDateTimeStamp()");
        System.out.println("================\n");
    }

    public void printBookInfo() {
        String output = "This book [" + title + "] is written by " + author;
        System.out.println(output);
    }

    // Helper method
    private int generateISBN() {
        int generated = (int)(Math.random() * 1000000)+1;
        return generated;
    }

    // Helper method
    private String getRegistrationDateTimeStamp() {
        Date date = new Date();
        String thisMoment = date.toString();
        return thisMoment;
    }
}
