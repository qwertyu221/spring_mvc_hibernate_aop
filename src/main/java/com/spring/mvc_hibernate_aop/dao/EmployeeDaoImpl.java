package com.spring.mvc_hibernate_aop.dao;




import com.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
//        List<Employee> employees = session.createQuery("from Employee",Employee.class)
//                .getResultList();

        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        List<Employee> allemployees = query.getResultList();

        return allemployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate( employee);
    }

    @Override
    public Employee getEmployee(int id) {
         Session session = sessionFactory.getCurrentSession();
         return session.get(Employee.class,id);
    }
}
