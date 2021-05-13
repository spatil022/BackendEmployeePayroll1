package com.bl.employeepayroll.controller;

import com.bl.employeepayroll.dto.EmployeePayrollDTO;
import com.bl.employeepayroll.dto.ResponseDTO;
import com.bl.employeepayroll.model.EmployeePayrollData;
import com.bl.employeepayroll.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    //curl localhost:8080/employeepayrollservice/get -w "\n"
    @RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl localhost:8080/employeepayrollservice/get/1 -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary":2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl -X PUT -H "Content-Type: application/json" -d '{"name": "Lisa","salary": 2000}' "http://localhost:8080/employeepayrollservice/update" -w "\n"
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl -X DELETE -H "Content-Type: application/json" localhost:8080/employeepayrollservice/delete/1 -w "\n"
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully ", empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}