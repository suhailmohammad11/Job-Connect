package com.Project.JobConnectPortal.DAO;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Project.JobConnectPortal.Model.JobApplications;
import com.Project.JobConnectPortal.Model.JobPostings;
import com.Project.JobConnectPortal.Repository.JobApplicationsRepo;
import com.Project.JobConnectPortal.Repository.JobPostingsRepo;

@Repository
public class JobseekerDAO {

    // Injecting the JobPostingsRepo to interact with the database
    @Autowired
    private JobPostingsRepo jobPostingsRepo;
    @Autowired
    private JobApplicationsRepo jobapplicationsrepo;

    // Method to get all job postings
    public List<JobPostings> getAllJobs() {
        return jobPostingsRepo.findAll();
    }

    // Method to get job postings by job name (job role)
    public List<JobPostings> allJobsByName(String jobname) {
        return jobPostingsRepo.findByJobName(jobname);
    }

    // Method to get job postings by company name
    public List<JobPostings> allJobsByCompany(String companyname) {
        return jobPostingsRepo.findByCompanyName(companyname);
    }
    public void saveJobApplication(JobApplications app) {
        jobapplicationsrepo.save(app);
    }
}

