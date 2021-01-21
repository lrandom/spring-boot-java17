package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class Session3Controller {
    @Value("${UPLOAD_FOLDER}")
    public String UPLOAD_FOLDER;
   @GetMapping("/set-cookie")
   public String setCookie(HttpServletResponse response){
        Cookie cookie =new Cookie("school", "NIIT");
        response.addCookie(cookie);
        return "session3/set-cookie";
   }

   @GetMapping("/get-cookie")
   public String getCookie(@CookieValue(value = "school") String school){
       System.out.println(school);
       return "session3/get-cookie";
   }

   @GetMapping("/set-session")
    public String setSession(HttpSession httpSession){
       User user = new User();
       user.setName("Luan");
       user.setAddress("QN");
       user.setFullname("Nguyen Thanh Luan");
       httpSession.setAttribute("user", user);
       return "session3/set-session";
    }

    @GetMapping("/get-session")
    public String getSession(Model model, HttpSession httpSession){
       User user = (User)httpSession.getAttribute("user");
       model.addAttribute("user", user);
       return "session3/get-session";
   }

   @GetMapping("/upload-file")
   public String uploadFile(){
       return "session3/upload-file";
   }

   @PostMapping("/do-upload-file")
   public String doUploadFile(@RequestParam(name = "img") MultipartFile file) {
       try {
           //buoc 1: convert file thanh mang bytes
           byte[] bytesFile = file.getBytes();

           //buoc 2: tao đối tuợng path
           Path path = Paths.get(UPLOAD_FOLDER+file.getOriginalFilename());

           //buoc 3: ghi file vào trong thư mục
           Files.write(path, bytesFile);

           //Hoan thanh
       } catch (Exception e) {
            e.printStackTrace();
       }
       return "redirect:/upload-file";
   }
}
