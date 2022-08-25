package com.wipro.javaassignment.dao;

import com.wipro.javaassignment.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserData,String> {
    UserData findByUserName(String userName);
}
