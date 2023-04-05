package com.javamicroservices.springbootdemo.service;

import com.javamicroservices.springbootdemo.exception.EmployeeNotFoundException;
import com.javamicroservices.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee save(Employee e) {
        // validation
        if(e.getEmployeeId() == null || e.getEmployeeId().isEmpty()){
            e.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(e);
        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeId(String id) {
        return employees.stream().filter(employee -> employee
                                    .getEmployeeId()
                                    .equals(id))
                                    .findFirst()
                                    .orElseThrow(() -> new EmployeeNotFoundException("" +
                                            "Employee not found with id: " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees
                .stream()
                .filter(e -> e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();

        employees.remove(employee);
        return "Employee deleted with id: " + id;
    }


}
