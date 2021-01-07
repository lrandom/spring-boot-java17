package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/do-login")
    public String doLogin(){
        return "login";
    }

    @GetMapping("/send-contact")
    public String sendContact(){
        return "send-contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String email,
                          @RequestParam String phone,
                          @RequestParam String name,
                          @RequestParam String message,
                          Model model
                          ){
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("name", name);
        model.addAttribute("message", message);
        return "contact";
    }
}
