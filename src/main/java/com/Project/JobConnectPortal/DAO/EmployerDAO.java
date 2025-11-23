package com.Project.JobConnectPortal.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.Project.JobConnectPortal.Model.Interview;
import com.Project.JobConnectPortal.Model.JobApplications;
import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Repository.InterviewRepo;
import com.Project.JobConnectPortal.Repository.JobApplicationsRepo;
import com.Project.JobConnectPortal.Repository.JobPostingsRepo;

@Repository
public class EmployerDAO {

    @Autowired
    private InterviewRepo interviewRepo;

    @Autowired
    private JobPostingsRepo jobRepo;

    @Autowired
    private JobApplicationsRepo applicationRepo;

    // Job Operations
    public List<JobPostings> getAllJobs() {
        return jobRepo.findAll();
    }

    public String addJob(JobPostings job) {
        jobRepo.save(job);
        return "Job added successfully!";
    }

    public String updateJob(int jobId,JobPostings job) {
        jobRepo.save(job);
        return "Job updated successfully!";
    }

    public String deleteJob(int jobId) {
        jobRepo.deleteById(jobId);
        return "Job deleted successfully!";
    }

    // Application Operations
    public List<JobApplications> getAllApplications() {
        return applicationRepo.findAll();
    }

    public String insertApplication(JobApplications application) {
        applicationRepo.save(application);
        return "Application added successfully!";
    }

    public String updateApplication(int applicationId) {
        Optional<JobApplications> app = applicationRepo.findById(applicationId);
        if (app.isPresent()) {
            app.get().setStatus("approved");
            applicationRepo.save(app.get());
            return "Application approved successfully!";
        }
        return "Application not found";
    }

    public String deleteApplication(int applicationId) {
        applicationRepo.deleteById(applicationId);
        return "Application deleted successfully!";
    }

    // Interview Operations
    public List<Interview> getAllInterviews() {
        return interviewRepo.findAll();
    }

    public ResponseEntity<Interview> addInterview(Interview interview) {
        return new ResponseEntity<>(interviewRepo.save(interview), HttpStatus.CREATED);
    }

    public ResponseEntity<Interview> getInterviewById(int interviewId) {
        Optional<Interview> interview = interviewRepo.findById(interviewId);
        return interview.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> updateInterview(int interviewId, Interview interview) {
        Optional<Interview> existingInterview = interviewRepo.findById(interviewId);
        if (existingInterview.isPresent()) {
            //Interview updatedInterview = existingInterview.get();
            existingInterview.get().setFeedback(interview.getFeedback());
            existingInterview.get().setInterview_status(interview.getInterview_status());
            interviewRepo.save(existingInterview.get());
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> deleteInterview(int interviewId) {
        Optional<Interview> interview = interviewRepo.findById(interviewId);
        if (interview.isPresent()) {
            interviewRepo.deleteById(interviewId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
