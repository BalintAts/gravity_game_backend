package com.gravGam.gravityGame.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

    public User(@NotEmpty String username, @NotEmpty String password) {
        this.username = username;
        this.password = password;
        this.progress = 0;
    }

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private int progress;
}
