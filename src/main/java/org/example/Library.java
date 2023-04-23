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
        }
        if (customerChoice == 2) {
            System.out.println("You've chosen option 2");
        }
        if (customerChoice == 3){
            System.out.println("You've chosen option 3");
        }

    }

    public static String loanBook(String bookNumber) {
//        find book by number, remove from available books, then add to loaned books. message about successfully loaning book!
        return bookNumber;
    }
    public static String returnBook(String bookNumber) {
//        find book by number, remove from loaned books, then add to available books. message about successfully returning book!
        return bookNumber;
    }
}
