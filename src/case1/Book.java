package case1;

import java.util.Date;

public class Book {
    //--Field--//
    String title;
    String author;
    int    isbn;
    String registrationDate;


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
    //--Methods--//

    public void showObjectState() {
        System.out.println("=====OBJECT======");
        System.out.println("Object Address: " + this);
        System.out.println("--FIELD ---");
        System.out.println("title  : " + title);
        System.out.println("author : " + author);
        System.out.println("isbn   : " + isbn);
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

    public int generateISBN() {
        int generated = (int)(Math.random() * 1000000)+1;
        return generated;
    }

    public String getRegistrationDateTimeStamp() {
        Date date = new Date();
        String thisMoment = date.toString();
        return thisMoment;
    }
}
