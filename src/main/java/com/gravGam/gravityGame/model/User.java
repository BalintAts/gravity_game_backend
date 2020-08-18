package com.gravGam.gravityGame.model;

public class User {
    private String name;
    private int score;
    private String password;

    public User(String name, int score, String password) {
        this.name = name;
        this.score = score;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
