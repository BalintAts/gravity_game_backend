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

    @CrossOrigin(origins = "*")
    @GetMapping("ladder")
    public List<User> getUserLadder(){
        return this.userStorage.getUserLadder();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/reg")
    public User register(@RequestBody User newUser){
        this.userStorage.addUser(newUser);
        return newUser;
    }

    /**@CrossOrigin(origins = "*")
     * @PostMapping("/{userName}")
        public User login(@PathVariable("userName") String userName) throws Exception {
        return UserStorage.findUser(userName);
    }**/

/*    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public String login(@PathVariable("username") String username){
        return username;
    }
    return userStorage.findUser(username);*/
}