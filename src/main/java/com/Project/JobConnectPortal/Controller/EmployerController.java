 package com.Project.JobConnectPortal.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.JobConnectPortal.Model.Interview;
import com.Project.JobConnectPortal.Model.JobApplications;
import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Service.EmployerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

   
    // Application APIs
    @GetMapping("/applications")
    public List<JobApplications> getAllApplications() {
        return employerService.getAllApplications();
    }

   

    @PutMapping("/approveApplication/{applicationId}")
    public String updateApplication(@PathVariable int applicationId) {
        return employerService.updateApplication(applicationId);
    }
    
    @DeleteMapping("/rejectApplication/{applicationId}")
    public String deleteApplication(@PathVariable int applicationId) {
    	return employerService.deleteApplication(applicationId);
    }

    // Job APIs
    @GetMapping("/jobs")
    public List<JobPostings> getAllJobs() {
        return employerService.getAllJobs();
    }

    @PostMapping("/addJob")
    public String addJob(@RequestBody JobPostings job) {
        return employerService.addJob(job);
    }

    @PutMapping("/updateJob/{jobId}")
    public ResponseEntity<Map<String, String>> updateJob(@PathVariable int jobId, @RequestBody JobPostings job) {
        String message = employerService.updateJob(jobId, job);
        Map<String, String> response = new HashMap<>();
        response.put("message", message); 
        return ResponseEntity.ok(response); 
    }


    @DeleteMapping("/deleteJob/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        return employerService.deleteJob(jobId);
    }

    // Interview APIs
    @GetMapping("/interviews")
    public List<Interview> getAllInterviews() {
        return employerService.getAllInterviews();
    }

    @PostMapping("/addInterview")
    public ResponseEntity<Interview> addInterview(@RequestBody Interview interview) {
        return employerService.addInterview(interview);
    }

    @GetMapping("/getInterview/{interviewId}")
    public ResponseEntity<Interview> getInterview(@PathVariable int interviewId) {
        return employerService.getInterviewById(interviewId);
    }

    @PutMapping("/updateInterview/{interviewId}")
    public ResponseEntity<?> updateInterview(@PathVariable int interviewId, @RequestBody Interview interview) {
        return employerService.updateInterview(interviewId, interview);
    }
}



