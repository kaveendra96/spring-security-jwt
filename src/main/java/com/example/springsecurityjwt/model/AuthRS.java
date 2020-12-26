package com.example.springsecurityjwt.model;

public class AuthRS {
    private final String jwt;

    public AuthRS(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
