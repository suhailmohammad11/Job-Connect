package com.Project.JobConnectPortal.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.JobConnectPortal.Model.JobApplications;
import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Service.JobseekerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/jobseeker")
public class JobseekerController {

    @Autowired
    private JobseekerService jobseekerservice;
   

    // Get all jobs
    @GetMapping("/alljobs")
    public List<JobPostings> allJobs(){
        return jobseekerservice.getAllJobs();
    }

    // Get job by name
    @GetMapping("/alljobs/byName/{jobName}")
    public ResponseEntity<List<JobPostings>> allJobsbyName(@PathVariable String jobName) {
        // Call the service to get the list of jobs
        ResponseEntity<List<JobPostings>> jobs = jobseekerservice.allJobsByName(jobName);

        // Check if the list is not empty and return the appropriate response
        if (jobs.getBody() != null && !jobs.getBody().isEmpty()) {
            return ResponseEntity.ok(jobs.getBody());  
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
        }
    }

 
    // Get job by Company
    @GetMapping("/alljobs/byCompany/{jobCompany}")
    public ResponseEntity<List<JobPostings>> allJobsbyCompany(@PathVariable String jobCompany) {
        // Call the service to get the jobs
        ResponseEntity<List<JobPostings>> jobs = jobseekerservice.allJobsByCompany(jobCompany);

        // Check if the list is not empty and return the appropriate response
        if (jobs.getBody() != null && !jobs.getBody().isEmpty()) {
            return ResponseEntity.ok(jobs.getBody());  
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
        }
    }


    @PostMapping("/jobapply")
    public String registerUser(@RequestBody JobApplications app) {
        try {
            jobseekerservice.saveJobApplication(app); 
            return "Application submitted successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    	
}


	
	
	
	
	
	


