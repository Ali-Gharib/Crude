package com.amigocrd.amigocrd.service;

import com.amigocrd.amigocrd.exception.UserNotFoundException;
import com.amigocrd.amigocrd.model.Employee;
import com.amigocrd.amigocrd.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo ;
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee (){
    return employeeRepo.findAll();
    }
    public Employee updateEmployee (Employee employee){
    return employeeRepo.save(employee);
    }
    public Employee findemployee(Long id){
    return employeeRepo.findEmployeeById(id).
            orElseThrow(()->new UserNotFoundException("User By id"+ id + "was not Find"));
    }
    public void deleteEmployee(Long id){
    employeeRepo.deleteEmployeeById(id);
    }


}
