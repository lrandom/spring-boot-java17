package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Session2Controller {

    @GetMapping("/session2/test1")
    public String test1(Model model){
        model.addAttribute("greeting", "Hello Java17");
        User user = new User();
        user.id = "1";
        user.name = "Nam";

        model.addAttribute("user", user);

        String[] alphabet = new String[]{"A","B","C"};
        model.addAttribute("alphabet", alphabet);

        model.addAttribute("condition", true);
        model.addAttribute("age", 18);
        return "session2/test1";
    }

    @GetMapping("/session2/test2")
    public String test2(){
        return "index";
    }

    @GetMapping("/session2/test3")
    public String test3(Model model, User user){
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/session2/test4")
    public String test4(User user, Model model){
        model.addAttribute("user", user);
        return "display";
    }
}
