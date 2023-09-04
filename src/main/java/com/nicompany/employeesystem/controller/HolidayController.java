package com.nicompany.employeesystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/holiday")
@CrossOrigin

public class HolidayController {

    @GetMapping("/holiday-details")
    public String holidayDetails(){
        return "Here's the holidays of the year....";
    }
}
