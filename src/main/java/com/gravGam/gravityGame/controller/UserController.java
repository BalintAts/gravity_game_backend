package com.gravGam.gravityGame.controller;

import com.gravGam.gravityGame.model.User;
import com.gravGam.gravityGame.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserStorage userStorage;

    @GetMapping("ladder")
    public List<User> getUserLadder(){
        return this.userStorage.getUserLadder();
    }

    @PostMapping("/reg")
    public User register(@RequestBody User newUser){
        this.userStorage.addUser(newUser);
        return newUser;
    }



    /**@PostMapping("/{userName}")
        public User login(@PathVariable("userName") String userName) throws Exception {
        return UserStorage.findUser(userName);
    }**/

    @PostMapping("/{userName}")
    public String login(@PathVariable("userName") String userName){
        return userName;
    }
}
