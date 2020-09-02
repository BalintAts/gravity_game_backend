package com.gravGam.gravityGame.service;

import com.gravGam.gravityGame.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserStorage {



    private List<User> users = new ArrayList<User>(Arrays.asList( new User(5000000000L,"BackendFakeUser 1","dsfkhsf",3),
            new User(5000000000L,"BackendFakeUser 2","dsfkhsf",2),
            new User(5000000000L,"BackendFakeUser 3","dsfkhsf",8),
            new User(5000000000L,"BackendFakeUser 4","dsfkhsf",3)));

    public User findUser(String userName) throws Exception {
        User foundUser = this.users.stream()
                .filter(user -> user.getName().equals(userName))
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
