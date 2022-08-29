package com.javaassignment.service;


import com.javaassignment.model.UserData;

import java.util.List;

public interface UserService {
    List<UserData> getUsers();
    UserData getUserByUserName(String userName);
    void saveUser(UserData userData);


    List<UserData> getUserswithSort(String field);

    List<UserData> findPaginated(int pageNo, int pageSize);
}
