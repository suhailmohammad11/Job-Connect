package com.Project.JobConnectPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.JobConnectPortal.Model.Users;

import java.util.List;
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

    List<Users> findByStatus(String status);
    
    Users findById(int userId);
    
    Users findByUserName(String userName);
    
    Users findByEmail(String email);
}

