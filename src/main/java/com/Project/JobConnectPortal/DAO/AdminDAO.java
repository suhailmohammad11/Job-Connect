package com.Project.JobConnectPortal.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Model.Users;
import com.Project.JobConnectPortal.Repository.JobApplicationsRepo;
import com.Project.JobConnectPortal.Repository.JobPostingsRepo;
import com.Project.JobConnectPortal.Repository.UsersRepo;

@Repository
public class AdminDAO {

    @Autowired
    private UsersRepo usersRepository;

    @Autowired
    private JobPostingsRepo jobPostingsRepository;

    @Autowired
    private JobApplicationsRepo jobsApplicationRepo;  // Inject the JobsApplicationRepo

    // Users-related methods

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(int userId) {
        return usersRepository.findById(userId);
    }

    public void updateUserStatus(Users user) {
        usersRepository.save(user);
    }

    public List<Users> getUsersByStatus(String status) {
        return usersRepository.findByStatus(status);
    }

    public Users findUserById(int userId) {
    	Optional<Users> user = Optional.of(usersRepository.findById(userId));
        return user.orElse(null); 
    }

    // Job Postings-related methods

    public List<JobPostings> getAllJobPostings() {
        return jobPostingsRepository.findAll();
    }

    public JobPostings getJobPostingById(int jobId) {
        return jobPostingsRepository.findById(jobId) ;
    }

    public void saveJobPosting(JobPostings jobPosting) {
        jobPostingsRepository.save(jobPosting);
    }

    public void deleteJobPosting(JobPostings jobPosting) {
        jobPostingsRepository.delete(jobPosting);
    }

    public List<Object[]> getJobApplicationsInsights() {
        return jobsApplicationRepo.getJobApplicationsInsights();  
    }

    public List<Object[]> getJobTrendsInsights() {
        return jobPostingsRepository.getJobTrendsInsights();  
    }
}
