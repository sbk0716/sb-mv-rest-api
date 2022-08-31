package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;

// ADD
import com.example.employee.exception.ResourceNotFoundException;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    // CREATE
    public Employee createEmployee(Employee emp) {
      return empRepository.save(emp);
    }

    // READ(ALL)
    public List<Employee> getEmployees() {
      return empRepository.findAll();
    }

    // READ
    public Employee getEmployee(Long empId) {
      Employee emp = empRepository.findById(empId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + empId));
      return emp;
    }

    // UPDATE
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
      // Employee emp = empRepository.findById(empId).get();
      Employee emp = empRepository.findById(empId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + empId));
      emp.setFirstName(employeeDetails.getFirstName());
      emp.setLastName(employeeDetails.getLastName());
      emp.setEmailId(employeeDetails.getEmailId());

      return empRepository.save(emp);
    }

    // DELETE
    public void deleteEmployee(Long empId) {
      empRepository.deleteById(empId);
    }

}
