package com.luv2code.springboot.springbootcrud.RestController;

import com.luv2code.springboot.springbootcrud.dao.EmployeeDao;
import com.luv2code.springboot.springbootcrud.entity.Employee;
import com.luv2code.springboot.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    //private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeDao) {
        this.employeeService = theEmployeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findbyid(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee Id is not found" + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        System.out.println("Entered");
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findbyid(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee Id is not found" + employeeId);
        }
        employeeService.delete(employeeId);
        return "Delete Employee Id" + employeeId;
    }
}
