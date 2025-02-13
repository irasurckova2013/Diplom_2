package org.example;

public class User {
    private String email;
    private String password;
    private String name;

    public User(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }


    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }
}
