	package com.Project.JobConnectPortal.Controller;
	
	import java.util.HashMap;
	import java.util.Map;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.Project.JobConnectPortal.Model.LoginRequest;
	import com.Project.JobConnectPortal.Model.Users;
	import com.Project.JobConnectPortal.Repository.UsersRepo;
	import com.Project.JobConnectPortal.Service.UserService;
	
	@RestController
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/api/users")
	public class UserController {
	
	    @Autowired
	    private UserService userservice; 
	    @Autowired
	    private UsersRepo usersrepo;
	
	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody Users user) {
	        try {
	            userservice.registerUser(user);  
	            return new ResponseEntity<>("Registration successful", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }
	    @PostMapping("/login")
	    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
	        // Call the service to validate the user
	        String result = userservice.login(loginRequest.getEmail(), loginRequest.getPassword(), loginRequest.getType());
	
	        // Prepare the response
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", result);  
	
	        // If service returns login success → send 200
	        if (result.equals("Login successful")) {
	        	Users user=usersrepo.findByEmail(loginRequest.getEmail());
	        	Map<String, String> userData= new HashMap<>();
	        	userData.put("userName", user.getUserName());
	        	userData.put("Email", user.getEmail());
	        	userData.put("Type", user.getType());
	        	userData.put("UserId", String.valueOf(user.getUserId()));
	        	response.put("user", userData);
	        }
	        
	            return ResponseEntity.ok(response);
	       
	     
	    }
	}
