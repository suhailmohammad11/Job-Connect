package com.Project.JobConnectPortal.Service;

import com.Project.JobConnectPortal.Model.Users;
import com.Project.JobConnectPortal.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;
        

	public void registerUser(Users user) {
		
        if (usersRepo.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists.");
       }
        if (usersRepo.findByUserName(user.getUserName()) != null) {
            throw new RuntimeException("Username already exists.");
        }

        user.setStatus("pending");

        usersRepo.save(user);
    }

	public String login(String email, String password, String type) {
        
        Users user = usersRepo.findByEmail(email);

        if (user == null) {
            return "Invalid email or password";
        }

        if (!user.getPassword().equals(password)) {
            return "Invalid email or password";
        }

        if (!user.getType().equals(type)) {
            return "Invalid user type";
        }

        if (!user.getStatus().equals("approved")) {
            return "Account not approved";
        }

        return "Login successful";
    }
}



