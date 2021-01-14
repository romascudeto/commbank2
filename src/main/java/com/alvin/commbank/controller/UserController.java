package com.alvin.commbank.controller;

import java.util.List;
import java.util.Optional;

import com.alvin.commbank.ResponseArray;
import com.alvin.commbank.ResponseObject;
import com.alvin.commbank.model.User;
import com.alvin.commbank.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers()
    {
        List<User> users = userRepository.findAll();
        ResponseArray resp = new ResponseArray(users);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity getUserById(@PathVariable(value="id") Long id)
    {
        Optional<User> user = userRepository.findById(id);
        ResponseObject resp;
        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        resp = new ResponseObject(user);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user)
    {
        userRepository.save(user);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable(value="id") Long id, @RequestBody User userDetails)
    {
        Optional<User> user = userRepository.findById(id);
        User userNew=user.get();
        userNew.setName(userDetails.getName());
        userNew.setPhone(userDetails.getPhone());
        ResponseObject resp = new ResponseObject(userRepository.save(userNew));
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable(value="id") Long id)
    {
        Optional<User> user=userRepository.findById(id);
        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        User user_new=user.get();
        userRepository.delete(user_new);
        ResponseObject resp = new ResponseObject(null);
        return ResponseEntity.ok(resp);
    }

}
