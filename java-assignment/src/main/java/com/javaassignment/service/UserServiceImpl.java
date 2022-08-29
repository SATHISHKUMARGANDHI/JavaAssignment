package com.javaassignment.service;

import com.javaassignment.model.UserData;
import com.javaassignment.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<UserData> getUserswithSort(String field) {
        //Todo: Pagination params can be introduced later
        List<UserData> result = new ArrayList<>();
        userRepo.findAll(Sort.by(Sort.Direction.ASC,field)).forEach(result::add);
        return result;
    }

    @Override
    public List<UserData> findPaginated(int pageNo, int pageSize) {
        //Todo: Pagination params can be introduced later
        //List<UserData> result = new ArrayList<>();
        Pageable paging = PageRequest.of(pageNo,pageSize);
        Page<UserData> pagedResult =userRepo.findAll(paging);
        return pagedResult.toList();
    }


}
