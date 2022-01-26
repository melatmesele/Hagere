package com.hagere.ethiop.Controllers;

import com.hagere.ethiop.Entity.User;
import com.hagere.ethiop.repositories.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@Data
public class formController {
@Autowired
    private final UserRepository userRepository;



    @GetMapping("/register.html")
    public String registrationForm(Model model, User user) {
        model.addAttribute("person", user);

        return "register";
    }


    @GetMapping("/login.html")
    public String logform() {

        return "login";
    }

@PostMapping("/login")
public String login(){
        return "main.html";
}
    @GetMapping("/home.html")
    public String backToHome() {

        return "home";
    }
    @GetMapping("/users.html")
    public String listUsers(Model model) {
        List<User> listUsers = (List<User>) userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";}
    @PostMapping("/register")
    public String processRegister(@Valid User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "login";
    }



    }
