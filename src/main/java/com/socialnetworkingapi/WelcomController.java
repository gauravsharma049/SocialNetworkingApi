package com.socialnetworkingapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomController {
    @GetMapping("/")
    public String welcome(){
        System.out.println("not working");
        return "dashboard";
    }
}
