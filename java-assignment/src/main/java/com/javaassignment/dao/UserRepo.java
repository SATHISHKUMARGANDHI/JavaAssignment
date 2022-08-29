package com.javaassignment.dao;

import com.javaassignment.model.UserData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<UserData,String> {
    UserData findByUserName(String userName);
}
