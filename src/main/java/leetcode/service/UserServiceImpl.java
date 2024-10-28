package leetcode.service;

import leetcode.dto.SignupRequest;
import leetcode.entity.User;
import leetcode.repository.UserRepository;
import leetcode.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;


    public User registerUser(SignupRequest signupRequest) {
        // Check if username or email is already in use
        if (userRepository.existsByUsername(signupRequest.getUsername()) ||
                userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Username or Email already exists");
        }


        User user = new User(signupRequest.getUsername(), signupRequest.getEmail(), signupRequest.getPassword());
        return userRepository.save(user);
    }


    public User loadUserByUsername(String usernameOrEmail) {
        // Logic to load user for authentication (Spring Security)
        return null;
    }

    public boolean validateUser(String username, String password) throws Status {
       try {
           User user = userRepository.findUserByUsername(username);
           if(user.getUsername().equals(username)&&user.getPassword().equals(password))
           {
               return true;
           }
       }catch (Exception e){
          throw new Status(HttpStatus.NOT_FOUND.toString(),"User Not Found");
       }
       return false;
       }

    }

