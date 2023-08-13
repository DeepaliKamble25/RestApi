package com.dipali.employee.controller;

import com.dipali.employee.entity.Employee;
import com.dipali.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
        Employee emp1 = employeeService.createEmp(emp);

        return new ResponseEntity<>(emp1, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getall() {

        List<Employee> employees = employeeService.getAllemp();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PutMapping("/{empId}/pro/{proId}")
    public ResponseEntity<Employee> setassignproject(
            @PathVariable Long empId,
            @PathVariable Long proId){

        Employee assignproject = this.employeeService.assignproject(empId, proId);
        return new ResponseEntity<>(assignproject,HttpStatus.OK);

    }

}
