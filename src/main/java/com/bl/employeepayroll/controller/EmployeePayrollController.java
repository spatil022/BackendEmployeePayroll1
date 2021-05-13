package com.bl.employeepayroll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class EmployeePayrollController {

    @GetMapping("/gethello")
    public String getHello() {
        return "Hello World";
    }
}