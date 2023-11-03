package com.spring.VideoCall.Video.Call.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {



    private final UserService userService;


    @PostMapping("/register")
    public void register(@RequestBody User user){
        System.out.println(user);
       userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
     return userService.login(user);

    }

    @PostMapping("/logout")
    public void logout(@RequestBody User user) {
        userService.logout(user.getEmail());
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

}
