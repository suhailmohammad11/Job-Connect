package com.Project.JobConnectPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.JobConnectPortal.DAO.EmployerDAO;
import com.Project.JobConnectPortal.Model.Interview;
import com.Project.JobConnectPortal.Model.JobApplications;
import com.Project.JobConnectPortal.Model.JobPostings;

@Service
public class EmployerService {

    @Autowired
    private EmployerDAO employerDAO;

    // Employer Operations (if applicable, can be extended with further details)
    public List<JobPostings> getAllJobs() {
        return employerDAO.getAllJobs();
    }

    public String addJob(JobPostings job) {
        return employerDAO.addJob(job);
    }

    public String updateJob(int jobId,JobPostings job) {
        return employerDAO.updateJob(jobId,job);
    }

    public String deleteJob(int jobId) {
        return employerDAO.deleteJob(jobId);
    }

    // Application Operation
    public List<JobApplications> getAllApplications() {
        return employerDAO.getAllApplications();
    }

    public String insertApplication(JobApplications app) {
  
        return employerDAO.insertApplication(app);
    }

    public String updateApplication(int applicationId) {
        return employerDAO.updateApplication(applicationId);
    }

    public String deleteApplication(int applicationId) {
        return employerDAO.deleteApplication(applicationId);
    }

    // Interview Operations
    public List<Interview> getAllInterviews() {
        return employerDAO.getAllInterviews();
    }

    public ResponseEntity<Interview> addInterview(Interview interview) {
        return employerDAO.addInterview(interview);
    }

    public ResponseEntity<Interview> getInterviewById(int interviewId) {
        return employerDAO.getInterviewById(interviewId);
    }

    public ResponseEntity<String> updateInterview(int interviewId, Interview interview) {
        return employerDAO.updateInterview(interviewId, interview);
    }

    public ResponseEntity<Void> deleteInterview(int interviewId) {
        return employerDAO.deleteInterview(interviewId);
    }

}
