/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Desmond
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {
    @PersistenceContext(unitName = "JPQLPracticeEJBModule2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public Employee searchLongestServing() {
     Query query=em.createQuery("SELECT s FROM EMPLOYEE s WHERE s.dateHired = (SELECT MIN(e.dateHired) FROM EMPLOYEE e)");
     Employee emp=(Employee) query.getSingleResult();
     return emp;
    }

    @Override
    public List<Employee> employeeWithinDateRange(Date minDate, Date maxDate) {
     Query query=em.createQuery("SELECT s FROM EMPLOYEE s WHERE s.dateHired>=:minDate AND s.dateHired<=:maxDate");
     query.setParameter("minDate",minDate );
     query.setParameter("maxDate",maxDate );
     List<Employee> emps=(List<Employee>) query.getResultList();
        return emps;
    }
    
}
