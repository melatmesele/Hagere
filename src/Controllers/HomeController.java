package com.hagere.ethiop.Controllers;

import com.hagere.ethiop.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {

        return "home";
    }
    @GetMapping("/main.html")
    public String logform() {

        return "main";
    }


    @GetMapping("/admin")
    public String admin(){
        return "this the  admin page";
    }


    @GetMapping("/propose.html")
    public String registrationForm(Model model, User user) {
        model.addAttribute("person", user);

        return "propose";
    }
    @PostMapping("/propose")
    public String login(){
        return "main";
    }



}
