package case1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Prompt & Process
        System.out.println("Hello Ultra Library Staff");
        System.out.println("Please enter book details one book at a time");
        System.out.println("Enter STOP to finish the entry");
        System.out.println("------------------------------------------------");
        String entry = "";
        Book[] bookDb = new Book[1000];
        int idx = 0;

        while(true) {

            System.out.print("Enter Book Title: ");
            entry = scan.nextLine();
            if(entry.equals("STOP")) {break;}

            String bookTitle = entry;
            System.out.print("Enter Book Author: ");
            entry = scan.nextLine();
            if(entry.equals("STOP")) {break;}

            String author = entry;
            System.out.println("--");
            Book item = new Book(bookTitle, author);
            bookDb[idx] = item;
            idx++;
        }

        System.out.println("Thank you for uploading books");
        System.out.println("You have uploaded: " + (idx));

        for(int i = 0; i < idx; i++) {
            Book each = bookDb[i];
            each.showObjectState();
        }

        // Fix script
        Book first = bookDb[0];
        first.setTitle("Mark Martin");
        System.out.println("ISBN: " + first.getIsbn());

        System.out.println("\n\n=====FOLLOWING BOOK WAS UPDATED=====");
        first.showObjectState();
    }
}
