package com.wipro.javaassignment.controller;

import com.wipro.javaassignment.model.UserData;
import com.wipro.javaassignment.service.UserService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
    public List<UserData> getPaginatedCountries(@PathVariable int pageNo,
                                               @PathVariable int pageSize) {

        return userService.findPaginated(pageNo, pageSize);
    }
}
