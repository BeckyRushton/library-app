package org.example;

import com.opencsv.exceptions.CsvException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static ArrayList<Book> allBooks = new ArrayList<>();
    public static ArrayList<Book> availableBooks = new ArrayList<>();
    public static ArrayList<Book> loanedBooks = new ArrayList<>();


    {
        try {
            BookInitialiser.csvToJson();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        try {
            BookInitialiser.init();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


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

    public static void printAllBooks() {
        for (Book book : allBooks
        ) {
            System.out.println(book);

        }
    }

    public static Book findBook(int id) {
        for (Book book : allBooks
        ) {
            if (book.getNumber().equals(String.valueOf(id))) {
                return book;
            }
        }
        return null;
    }

    public static void loanBook(int id) {
        Book targetBook = findBook(id);
        allBooks.remove(targetBook);
        loanedBooks.add(targetBook);
        System.out.println("Thanks, you've successfully loaned this book!");
        System.out.println(loanedBooks);
    }

    public static void returnBook(int id) {
        Book targetBook = findBook(id);
        loanedBooks.remove(targetBook);
        allBooks.add(targetBook);
        System.out.println("Thanks, you've successfully returned this book!");
    }

    public static void enterTheLibrary() {
        boolean isLoggedOn = true;
        System.out.println("Welcome to the library! Please tell me your name so I can access your account?");
        Scanner scanner = new Scanner(System.in);
        String newCustomer = scanner.nextLine();

        while (isLoggedOn) {
            System.out.println("Hi " + newCustomer + ". What would you like to do today?");
            System.out.println("Press 1 to see all the books we carry in this library");
            System.out.println("Press 2 to loan a book");
            System.out.println("Press 3 to return a book");
            int customerChoice = scanner.nextInt();
            if (customerChoice == 1) {
                System.out.println("You've chosen option 1");
                System.out.println("Here's all the books this library carries...");
                printAllBooks();
            }
            if (customerChoice == 2) {
                System.out.println("You've chosen option 2");
                System.out.println("Please enter the book ID number to loan it...");
                int bookId = scanner.nextInt();
                loanBook(bookId);

            }
            if (customerChoice == 3) {
                System.out.println("You've chosen option 3");
                System.out.println("Here is a list of books you can return to the library...");
                System.out.println(loanedBooks);
                int bookId =scanner.nextInt();
                returnBook(bookId);

            }
        }
    }


}
