package com.gravGam.gravityGame.controller;

import com.gravGam.gravityGame.model.UserCredentials;
import com.gravGam.gravityGame.repository.UserRepository;
import com.gravGam.gravityGame.security.JwtTokenServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
//
//    @Autowired
//    private UserStorage userStorage;
//
//    @GetMapping("ladder")
//    public List<User> getUserLadder(){
//        return this.userStorage.getUserLadder();
//    }
//
//    @CrossOrigin(origins = "*")
//    @PostMapping("/reg")
//    public User register(@RequestBody User newUser){
//        this.userStorage.addUser(newUser);
//        return newUser;
//    }
//
//   //@PostMapping  //loginpage?
//
//    @PostMapping("/{userName}")
//        public User login(@PathVariable("userName") String userName) throws Exception {
//        User user =  userStorage.findUser(userName);
//        System.out.println(user);
//        return user;
//    }

   private final AuthenticationManager authenticationManager;

   private final JwtTokenServices jwtTokenServices;

    public UserController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, UserRepository users) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserCredentials data) {
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            String token = jwtTokenServices.createToken(username);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}
