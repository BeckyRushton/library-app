package org.example;

import java.util.ArrayList;

public class User {
    String username;
    int userId;
    public ArrayList<Book> userBooks = new ArrayList<>();

    public User(String username, int userId, ArrayList<Book> userBooks) {
        this.username = username;
        this.userId = userId;
        this.userBooks = userBooks;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Book> getUserBooks() {
        return userBooks;
    }

    @Override
    public String toString() {
        return "Hi " + username + " your user ID is " + userId + " and the books you have loaned are " + userBooks;
    }
}
