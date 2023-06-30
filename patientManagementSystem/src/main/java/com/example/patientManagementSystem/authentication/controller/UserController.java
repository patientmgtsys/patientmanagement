package com.example.patientManagementSystem.authentication.controller;

import com.example.patientManagementSystem.authentication.exception.UserAlreadyExistsException;
import com.example.patientManagementSystem.authentication.exception.UserNotFoundException;
import com.example.patientManagementSystem.authentication.jwtConfig.SecurityTokenGenerator;
import com.example.patientManagementSystem.authentication.model.User;
import com.example.patientManagementSystem.authentication.repository.UserRepository;
import com.example.patientManagementSystem.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {

    private UserRepository userRepository;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserRepository userRepository, SecurityTokenGenerator securityTokenGenerator) {
        this.userRepository = userRepository;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    //Implement the  method to register a user

    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody User user)  {

        User user1 = userRepository.login(user);

        if (user1 != null) {
            return new ResponseEntity<>("login faild", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(securityTokenGenerator.generateToken(user1), HttpStatus.OK);

    }


    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers()  {
        return new ResponseEntity<>(userRepository.getAllUser(), HttpStatus.OK);
    }
}
