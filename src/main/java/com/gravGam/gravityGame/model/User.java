package com.gravGam.gravityGame.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public User( String username,  String password) {
        this.username = username;
        this.password = password;
        this.progress = 0;
    }

    private String username;


    private String password;

    private int progress;

    public Object getName() {
        return username;
    }
}


//package com.gravGam.gravityGame.model;
//
//public class User {
//    private String name;
//    private int score;
//    private String password;
//
//    public User(String name, int score, String password) {
//        this.name = name;
//        this.score = score;
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}
