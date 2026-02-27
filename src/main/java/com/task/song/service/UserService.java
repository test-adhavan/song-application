package com.task.song.service;

import com.task.song.entity.User;
import com.task.song.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository repository;

    UserService(UserRepository repository){
        this.repository=repository;
    }


    public void createuser(User user) {

       Optional<User> check =  repository.findByUsername(user.getUsername());
       if(check.isPresent()){
           throw new RuntimeException("User Already registered");
       }

        repository.save(user);
    }

    public void login(User user) {

      User us =   repository.findByUsername(user.getUsername())
              .orElseThrow(() -> new RuntimeException("user not found"));

      if(! us.getPassword().equals(user.getPassword())){

         throw new RuntimeException("invalid passwword");
      }


    }
}
