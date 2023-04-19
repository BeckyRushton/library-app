package org.example;

import java.util.ArrayList;

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
    public static String loanBook(String bookNumber) {
//        find book by number, remove from available books, then add to loaned books. message about successfully loaning book!
        return bookNumber;
    }
    public static String returnBook(String bookNumber) {
//        find book by number, remove from loaned books, then add to available books. message about successfully returning book!
        return bookNumber;
    }
}
