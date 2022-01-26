package com.hagere.ethiop.Controllers;

import com.hagere.ethiop.Entity.problem;
import com.hagere.ethiop.repositories.problemRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Data
public class postController {
    @Autowired
    private final problemRepository problemRepo;


    @GetMapping("/post.html")
    public String registrationForm(Model model, problem problem) {
        model.addAttribute("problem",problem );

        return "post";
    }
    @PostMapping("/post")
public String post(problem problem){
      problemRepo.save(problem);



        return "redirect:/main.html";

    }


}
