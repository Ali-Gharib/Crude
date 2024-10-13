package com.amigocrd.amigocrd.controller;

import com.amigocrd.amigocrd.model.Employee;
import com.amigocrd.amigocrd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService ;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee (){
    List<Employee> employees =  employeeService.findAllEmployee();
    return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeeById (@PathVariable("id") Long id){
        Employee employee =  employeeService.findemployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
    Employee newEmployee = employeeService.addEmployee(employee);
    return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmploye(@RequestBody Employee employee){
    Employee UupdateEmploye = employeeService.updateEmployee(employee);
    return  new ResponseEntity<>(UupdateEmploye , HttpStatus.OK);

    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
     employeeService.deleteEmployee(id);
     return  new ResponseEntity<>(HttpStatus.OK);

    }

}
