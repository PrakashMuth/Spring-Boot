package com.luv2code.springboot.springbootcrud.dao;

import com.luv2code.springboot.springbootcrud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class employeeDaoImple implements EmployeeDao {
    private EntityManager entityManager;


    @Autowired
    public employeeDaoImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        /* List<Employee> temp=employees
                .stream()
                .filter(e -> e.getLastName().equals("Andrews") )
                .sorted(Comparator.comparing(Employee::getId).reversed())
                .collect(Collectors.toList());
        System.out.println(temp);
         */
        List<Employee> temp1=employees
                .stream()
                .filter(e -> e.getFirstName().equals("Prakash"))
                .sorted()
                .collect(Collectors.toList());

        return temp1;
    }

    @Override
    public Employee findbyid(int id) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int theid) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee where Id =: employeeid");
        query.setParameter("employeeid", theid);
        query.executeUpdate();
    }
}
