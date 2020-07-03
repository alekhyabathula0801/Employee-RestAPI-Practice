package com.demo.controller;

import com.demo.model.Employee;
import com.demo.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @DeleteMapping("/employee")
    public void deleteEmployees() {
        employeeRepository.deleteAll();
    }

}
