package com.luv2code.springboot.springbootcrud.service;

import com.luv2code.springboot.springbootcrud.dao.EmployeeDao;
import com.luv2code.springboot.springbootcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceimple implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceimple(@Qualifier("employeeDaoImple") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findbyid(int id) {
        return employeeDao.findbyid(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDao.delete(id);
    }

}
