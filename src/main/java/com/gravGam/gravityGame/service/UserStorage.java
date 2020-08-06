package com.gravGam.gravityGame.service;

import com.gravGam.gravityGame.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStorage {

    private List<User> users = new ArrayList<User>();

    public List<User> getUserLadder() {
        return this.users;  //later ordering
    }

    public User addUser(User user){
        this.users.add(user);
        return user;
    }
}
