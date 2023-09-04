package com.nicompany.employeesystem.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin

public class EmployeeController {

    @GetMapping("/employee-details")
//    @Secured("ROLE_employee")
    @PreAuthorize("hasAnyAuthority('ROLE_employee')")
//    @PostAuthorize("hasAnyAuthority('ROLE_employee')")
    public String employeeDetails(){
        return "Here's the employee details...";
    }
}
