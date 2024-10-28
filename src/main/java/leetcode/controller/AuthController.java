package leetcode.controller;

import leetcode.dto.LoginRequest;
import leetcode.dto.SignupRequest;
import leetcode.service.UserServiceImpl;
import leetcode.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
  //  private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequest signupRequest) {
        try {
            userService.registerUser(signupRequest);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) throws Status {
            userService.validateUser(loginRequest.getUsername(),loginRequest.getPassword());
            return ResponseEntity.ok("login successfully!");

    }

}
