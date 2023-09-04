package com.nicompany.employeesystem.controller;

import com.nicompany.employeesystem.model.Employee;
import com.nicompany.employeesystem.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/emp-save")

public class EmpSaveController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee saveDTO) {

        ResponseEntity response = null;

        try {

            String hashPassword = passwordEncoder.encode(saveDTO.getPassword());
            saveDTO.setPassword(hashPassword);
            saveDTO.setRole("ROLE_" + saveDTO.getRole());
            Employee saveEmp = employeeRepo.save(saveDTO);

            if (saveEmp.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body(saveDTO.getEmail() +" save successfully....");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error : " + e.getMessage());
        }
        return response;
    }
}
