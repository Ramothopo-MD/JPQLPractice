/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Desmond
 */
@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee searchLongestServing();
    
    List<Employee> employeeWithinDateRange(Date minDate,Date maxDate);
    
    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
}
