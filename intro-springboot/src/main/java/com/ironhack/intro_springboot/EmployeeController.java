package com.ironhack.intro_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status")
    public List<Employee> getEmployeesByStatus(@RequestParam String status) {
        return employeeService.getEmployeesByStatus(status);
    }

    @GetMapping("/department")
    public List<Employee> getEmployeesByDepartment(@RequestParam String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
}
