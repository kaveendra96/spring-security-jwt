package com.example.springsecurityjwt.model;

public class AuthRQ {

    private String username;
    private String password;

    public AuthRQ(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthRQ() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
