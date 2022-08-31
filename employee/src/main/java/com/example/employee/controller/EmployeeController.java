package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

// ADD
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    // CREATE
    @RequestMapping(value="/employees", method=RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        Employee resp = empService.createEmployee(emp);
        return ResponseEntity.ok(resp);
    }

    // READ(ALL)
    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    // READ
    @RequestMapping(value="/employees/{empId}", method=RequestMethod.GET)
    public ResponseEntity<Employee> readEmployee(@PathVariable(value = "empId") Long id) {
        Employee resp = empService.getEmployee(id);
        return ResponseEntity.ok(resp);
    }

    // UPDATE
    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        Employee resp = empService.updateEmployee(id, empDetails);
        return ResponseEntity.ok(resp);
    }

    // DELETE
    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
        ResponseEntity<HttpStatus> resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return resp;
    }
}
