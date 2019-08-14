package com.luv2code.springboot.springbootcrud.dao;

import com.luv2code.springboot.springbootcrud.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();

    public Employee findbyid(int id);

    public void save(Employee employee);

    public void delete(int id);
}
