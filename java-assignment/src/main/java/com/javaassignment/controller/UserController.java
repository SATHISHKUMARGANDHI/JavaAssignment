package com.javaassignment.controller;

import com.javaassignment.model.UserData;
import com.javaassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    public ResponseEntity<List<UserData>> getAllUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("user/{username}")
    public ResponseEntity<UserData> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getUserByUserName(username), HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity saveUser(@RequestBody UserData userData){
        userService.saveUser(userData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{field}")
    public ResponseEntity<List<UserData>> getUserswithsort(@PathVariable String field){
                   return new ResponseEntity<>(userService.getUserswithSort(field), HttpStatus.OK);
        }
       @GetMapping(value = "/user/{pageNo}/{pageSize}")
    public List<UserData> getUserPaginated(@PathVariable int pageNo,
                                               @PathVariable int pageSize) {

        return userService.findPaginated(pageNo, pageSize);
    }
}
