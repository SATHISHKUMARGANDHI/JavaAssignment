package com.wipro.javaassignment.service;


import com.wipro.javaassignment.model.UserData;

import java.util.List;

public interface UserService {
    List<UserData> getUsers();
    UserData getUserByUserName(String userName);
    void saveUser(UserData userData);




}
