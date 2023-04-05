package com.javamicroservices.springbootdemo.controller;

import com.javamicroservices.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Harsha Vardhan Bashavathini");
        user.setEmailId("harshavardhan.bashavathini@gmail.com");
        return user;
    }

    @GetMapping("/{id1}/{id2}")
    public String pathVariable(@PathVariable String id1, @PathVariable("id2") String name){
        return "The Path Variables are: " + id1 + " " + name;
    }

    @GetMapping("/requestParam")
    // ?name=Harsha&email=harsha@gmail.com in URL
    public String requestParams(@RequestParam String name,
                                @RequestParam(name = "email",
                                        required = false,
                                        defaultValue = "")String emailId){
        return "Your name is: " + name + " and email id: " + emailId;
    }
}
