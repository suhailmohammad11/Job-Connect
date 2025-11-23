package com.Project.JobConnectPortal.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.JobConnectPortal.DAO.JobseekerDAO;
import com.Project.JobConnectPortal.Model.JobApplications;
import com.Project.JobConnectPortal.Model.JobPostings;

@Service
public class JobseekerService {

	@Autowired
	private JobseekerDAO jobseekerDAO;

	// Get all jobs from the database
	public List<JobPostings> getAllJobs(){
		return jobseekerDAO.getAllJobs();  
	}

	public ResponseEntity<List<JobPostings>> allJobsByName(String jobname) {
		// Find all jobs by the job name (job role)
		List<JobPostings> jobsList = jobseekerDAO.allJobsByName(jobname); 

		if (!jobsList.isEmpty()) {
			return ResponseEntity.ok(jobsList);  
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
		}
	}

	public ResponseEntity<List<JobPostings>> allJobsByCompany(String companyname) {
	    List<JobPostings> jobsList = jobseekerDAO.allJobsByCompany(companyname);

	    if (!jobsList.isEmpty()) {
	        return ResponseEntity.ok(jobsList);  
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
	    }
	}

	// Service method to save job application
    public void saveJobApplication(JobApplications app) {
        jobseekerDAO.saveJobApplication(app); 
    }
}
