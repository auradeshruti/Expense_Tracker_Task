package com.et.task.controller;

import com.et.task.model.Users;
import com.et.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    
    @PostMapping("/register")
    public String registerUser(@Validated  @ModelAttribute("user") Users user, 
                                BindingResult bindingResult, Model model) { 

        if (bindingResult.hasErrors()) {
            return "register"; 
        }

        if (userService.isUsernameTaken(user.getUsername())) {
            model.addAttribute("usernameError", "Username already exists.");
            return "register";
        }

       
        userService.registerUser(user); 

        return "redirect:/login?registrationSuccess"; 
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
        
        @PostMapping("/login")
        public String loginUser(@ModelAttribute("username") String username, @ModelAttribute("password") String password, Model model) {
            boolean loginSuccessful = userService.login(username, password);
            
            if (loginSuccessful) {
                return "redirect:/home";  // Redirect to the  home page after successful login
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        
    }
}

