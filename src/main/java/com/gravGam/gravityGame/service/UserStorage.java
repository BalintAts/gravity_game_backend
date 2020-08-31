package com.gravGam.gravityGame.service;

import com.gravGam.gravityGame.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserStorage {


    private List<User> users = new ArrayList<User>(Arrays.asList(new User("aaa", "111")));


    public User findUser(String userName) throws Exception {
        User foundUser = this.users.stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst()
                .orElseThrow(() -> new Exception("User not found, " + userName));
        return foundUser;
    }

    public List<User> getUserLadder() {
        return this.users;  //later ordering
    }

    public User addUser(User user){
        this.users.add(user);
        return user;
    }
}
