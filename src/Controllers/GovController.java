package com.hagere.ethiop.Controllers;

import com.hagere.ethiop.Entity.governmentOffice;
import com.hagere.ethiop.repositories.governmentOfficeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Data
public class GovController {
    @Autowired
    private final governmentOfficeRepository governmentOfficeRepository;


    @GetMapping("/govRegister.html")
    public String registrationForm(Model model, governmentOffice gov) {
        model.addAttribute("gov", gov);

        return "govRegister";
    }

    @PostMapping("/registerGov")
    public String processRegister(@Valid @ModelAttribute governmentOffice gov, HttpSession session) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(gov.getPassword());
        gov.setPassword(encodedPassword);

        governmentOfficeRepository.save(gov);

        return "redirect:/main.html";
    }
}
