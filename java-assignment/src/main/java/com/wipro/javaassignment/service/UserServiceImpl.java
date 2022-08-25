package com.wipro.javaassignment.service;

import com.wipro.javaassignment.dao.UserRepo;
import com.wipro.javaassignment.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserData> getUsers() {
        //Todo: Pagination params can be introduced later
        List<UserData> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);
        return result;
    }

    @Override
    public UserData getUserByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public void saveUser(UserData userData) {
        userRepo.save(userData);
    }
}
