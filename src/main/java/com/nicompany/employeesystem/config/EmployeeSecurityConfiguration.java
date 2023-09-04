package com.nicompany.employeesystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)

public class EmployeeSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/v1/employee/employee-details").authenticated()
//                .antMatchers("/api/v1/employee/employee-details").hasAuthority("employee")

                .antMatchers("/api/v1/employee/employee-details").hasRole("employee")
//                .antMatchers("/api/v1/payroll/payroll-details").hasAuthority("admin")
                .antMatchers("/api/v1/payroll/payroll-details").hasRole("admin")
                .antMatchers("/api/v1/holiday/holiday-details", "/api/v1/emp-save/register").permitAll()
                .and().formLogin().and().httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
