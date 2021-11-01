package com.ivanryabov.spring.rest.controller;

import com.ivanryabov.spring.rest.entity.Employee;
import com.ivanryabov.spring.rest.entity.Grade;
import com.ivanryabov.spring.rest.exceptionHandling.EmployeeIncorrectData;
import com.ivanryabov.spring.rest.exceptionHandling.NoSuchEmployeeException;
import com.ivanryabov.spring.rest.service.EmployeeService;
import com.ivanryabov.spring.rest.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GradeService gradeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployee(employeeId);

        if(employee == null){
            throw new NoSuchEmployeeException("There id no Employye with id = "
                    + employeeId + "in Database");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){

        employeeService.addEmployee(employee);

        return employee;
    }

    @PostMapping("/grades")
    public Grade addNewGrade(@RequestBody Grade grade){

        gradeService.addGrade(grade);

        return grade;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + "was deleted";
    }

}
