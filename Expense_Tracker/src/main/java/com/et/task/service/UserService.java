package com.et.task.service;

import com.et.task.model.Users;
import com.et.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(Users user) {
        userRepository.save(user);
    }
        
        public boolean login(String username, String password) {
            Users user = userRepository.findByUsername(username);
            
    
            return user != null && user.getPassword().equals(password);
        
    }
        public boolean isUsernameTaken(String username) {
            return userRepository.existsByUsername(username);
        }
}
