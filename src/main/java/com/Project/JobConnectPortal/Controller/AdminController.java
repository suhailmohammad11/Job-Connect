package com.Project.JobConnectPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Model.Users;
import com.Project.JobConnectPortal.Service.AdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // User-related endpoints

    @GetMapping("/users/getAllUsers")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable int userId) {
        Users user = adminService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);  
    }

    @PutMapping("/users/status")
    public ResponseEntity<String> updateUserStatus(@RequestBody Users user) {
        String result = adminService.updateUserStatus(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/users/approve/{userId}")
    public ResponseEntity<Map<String, String>> approveUser(@PathVariable int userId) {
        String result = adminService.approveUser(userId);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        if (result.equals("User not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/users/deactivate/{userId}")
    public ResponseEntity<String> deactivateUser(@PathVariable int userId) {
        String result = adminService.deactivateUser(userId);
        if (result.equals("User not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);  
    }

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable int userId, @RequestBody Users updatedUser) {
        String result = adminService.updateUser(userId, updatedUser);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        if (result.equals("User not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/users/status/{status}")
    public ResponseEntity<List<Users>> getUsersByStatus(@PathVariable String status) {
        List<Users> users = adminService.getUsersByStatus(status);
        return ResponseEntity.ok(users);
    }

    
    
    // Job Posting-related endpoints

    @GetMapping("/jobpostings/all")
    public ResponseEntity<List<JobPostings>> getAllJobPostings() {
        List<JobPostings> jobPostings = adminService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }

    @PutMapping("/jobpostings/approve/{jobId}")
    public ResponseEntity<Map<String, String>> approveJobPosting(@PathVariable int jobId) {
        String result = adminService.approveJobPosting(jobId);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        if (result.equals("Job not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/jobpostings/delete/{jobId}")
    public ResponseEntity<Map<String, String>> deleteJobPosting(@PathVariable int jobId) {
        String result = adminService.deleteJobPosting(jobId);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);

        if (result.equals("Job not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Job Trends endpoint

    @GetMapping("/insights/jobstrends")
    public ResponseEntity<List<Object[]>> getJobTrendsInsights() {
        List<Object[]> trends = adminService.getJobTrendsInsights();
        return ResponseEntity.ok(trends);
    }

    // Job Application Insights endpoint
    @GetMapping("/insights/userinsights")
    public ResponseEntity<List<Object[]>> getJobApplicationsInsights() {
        List<Object[]> insights = adminService.getJobApplicationsInsights();
        return ResponseEntity.ok(insights);
    }
}
