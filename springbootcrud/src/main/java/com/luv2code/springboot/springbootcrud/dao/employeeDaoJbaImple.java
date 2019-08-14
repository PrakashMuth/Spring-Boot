package com.luv2code.springboot.springbootcrud.dao;

import com.luv2code.springboot.springbootcrud.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class employeeDaoJbaImple implements EmployeeDao {
    private EntityManager entityManager;


    @Autowired
    public employeeDaoJbaImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query theQuery = entityManager.createQuery("from Employee");

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findbyid(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public void save(Employee theemployee) {
        Employee employee = entityManager.merge(theemployee);
        theemployee.setId(employee.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Employee where Id =: employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
