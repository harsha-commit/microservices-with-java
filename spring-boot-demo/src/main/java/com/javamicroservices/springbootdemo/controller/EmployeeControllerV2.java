package com.javamicroservices.springbootdemo.controller;

import com.javamicroservices.springbootdemo.model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeControllerV2 {
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employee;
    }
}
