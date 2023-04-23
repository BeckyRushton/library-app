package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static ArrayList<Book> allBooks = new ArrayList<>();
    public static ArrayList<Book> availableBooks = new ArrayList<>();
    public static ArrayList<Book> loanedBooks = new ArrayList<>();

    public void addToAllBooks(Book book) {
        allBooks.add(book);
    }
    public void addToAvailableBooks(Book book) {
        availableBooks.add(book);
    }
    public void addToLoanedBooks(Book book) {
        loanedBooks.add(book);
    }
    public void removeFromAvailableBooks(Book book) {
        availableBooks.remove(book);
    }
    public void removeFromLoanedBooks(Book book) {
        loanedBooks.remove(book);
    }

    public static void enterTheLibrary() {
        System.out.println("Welcome to the library! Please tell me your name so I can access your account?");
        Scanner scanner = new Scanner(System.in);
        String newCustomer = scanner.nextLine();
        System.out.println("Hi " + newCustomer + ". What would you like to do today?");
        System.out.println("Press 1 to see all the books we carry in this library");
        System.out.println("Press 2 to loan a book");
        System.out.println("Press 3 to return a book");
        int customerChoice = Integer.parseInt(scanner.nextLine());
        if (customerChoice == 1) {
            System.out.println("You've chosen option 1");
            System.out.println("Here's all the books this library carries...");
            System.out.println(allBooks);
        }
        if (customerChoice == 2) {
            System.out.println("You've chosen option 2");
            System.out.println("Please enter the book ID number to loan it...");
            System.out.println(availableBooks);
        }
        if (customerChoice == 3){
            System.out.println("You've chosen option 3");
            System.out.println("Here is a list of books you can return to the library...");
            System.out.println(loanedBooks);
        }

    }

    public static String loanBook(String bookNumber) {
//        find book by number, remove from available books, then add to loaned books. message about successfully loaning book!
        System.out.println("You have successfully loaned this book. Please return it at your earliest convenience.");
        System.out.println("Would you like to do anything else in the library today?");
        return bookNumber;
    }
    public static String returnBook(String bookNumber) {
//        find book by number, remove from loaned books, then add to available books. message about successfully returning book!
        System.out.println("You have successfully returned that book!");
        System.out.println("Would you like to do anything else in the library today?");
        return bookNumber;
    }
}
