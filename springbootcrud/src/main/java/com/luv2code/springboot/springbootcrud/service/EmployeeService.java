package com.luv2code.springboot.springbootcrud.service;

import com.luv2code.springboot.springbootcrud.entity.Employee;

import java.util.*;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findbyid(int id);

    public void save(Employee employee);

    public void delete(int id);
}
