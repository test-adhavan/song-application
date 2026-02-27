package com.task.song.controller;


import com.task.song.entity.User;
import com.task.song.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private UserService service;

    UserController(UserService service){
        this.service=service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createuser(@RequestBody User user){

        service.createuser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("user created sucessfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkuser(@RequestBody User user){

        service.login(user);

        return ResponseEntity.ok("login sucessfully");

    }



}
