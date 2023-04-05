package com.javamicroservices.springbootdemo.service;

import com.javamicroservices.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee save(Employee e);
    List<Employee> getAllEmployees();
    Employee getEmployeeId(String id);

    String deleteEmployeeById(String id);
}
