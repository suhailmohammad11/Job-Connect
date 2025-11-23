package com.Project.JobConnectPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.JobConnectPortal.DAO.AdminDAO;
import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Model.Users;


@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

public List<Users> getAllUsers() {
        return adminDAO.getAllUsers();
    }

    public String updateUserStatus(Users user) {
        adminDAO.updateUserStatus(user);
        return "Status updated successfully";
    }

    public Users getUserById(int userId) {
        return adminDAO.getUserById(userId);
    }

    public String approveUser(int userId) {
        Users user = adminDAO.findUserById(userId);
        if (user != null) {
            user.setStatus("approved");
            adminDAO.updateUserStatus(user);
            return "User approved successfully";
        }
        return "User not found";
    }

    public String deactivateUser(int userId) {
        Users user = adminDAO.findUserById(userId);
        if (user != null) {
            user.setStatus("deactivated");
            adminDAO.updateUserStatus(user);
            return "User deactivated successfully";
        }
        return "User not found";
    }

    public String updateUser(int userId, Users updatedUser) {
        Users user = adminDAO.findUserById(userId);
        if (user != null) {
            user.setUserName(updatedUser.getUserName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setType(updatedUser.getType());
            user.setStatus(updatedUser.getStatus());
            adminDAO.updateUserStatus(user);
            return "User updated successfully";
        }
        return "User not found";
    }

    public List<Users> getUsersByStatus(String status) {
        return adminDAO.getUsersByStatus(status);
    }

    // Job Postings-related operations

    public List<JobPostings> getAllJobPostings() {
        return adminDAO.getAllJobPostings();
    }

    public String approveJobPosting(int jobId) {
        JobPostings jobPosting = adminDAO.getJobPostingById(jobId);
        if (jobPosting != null) {
            jobPosting.setStatus("approved");
            adminDAO.saveJobPosting(jobPosting);
            return "Job approved successfully";
        }
        return "Job not found";
    }

    public String deleteJobPosting(int jobId) {
        JobPostings jobPosting = adminDAO.getJobPostingById(jobId);
        if (jobPosting != null) {
            adminDAO.deleteJobPosting(jobPosting);
            return "Job deleted successfully";
        }
        return "Job not found";
    }

    // Job Trends method

    public List<Object[]> getJobTrendsInsights() {
        return adminDAO.getJobTrendsInsights();
    }

    // Job Applications Insights (from JobsApplicationService)

    public List<Object[]> getJobApplicationsInsights() {
        return adminDAO.getJobApplicationsInsights();  
    }
}
