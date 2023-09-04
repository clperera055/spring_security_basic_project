package com.nicompany.employeesystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payroll")
@CrossOrigin
public class PayRollController {

    @GetMapping("/payroll-details")
    public String payrollDetails(){
        return "Here's the payroll details...";
    }
}
