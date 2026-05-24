package com.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    List<Employee> employees = new ArrayList<>();

    public EmployeeController() {

        employees.add(new Employee(1, "Vikas"));
        employees.add(new Employee(2, "Rahul"));

    }

    @GetMapping("/")
    public String home() {

        System.out.println("Home API called");

        return "Java App Running on AKS";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        System.out.println("Fetching employees");

        return employees;
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee) {

        employees.add(employee);

        System.out.println("Employee added: " + employee.getName());

        return "Employee Added";
    }
}