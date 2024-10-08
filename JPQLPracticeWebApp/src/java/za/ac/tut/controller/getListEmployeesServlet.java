/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entity.Employee;

import za.ac.tut.entity.EmployeeFacadeLocal;


/**
 *
 * @author Desmond
 */
public class getListEmployeesServlet extends HttpServlet {

   @EJB EmployeeFacadeLocal efl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Employee> emps=efl.findAll();
            request.setAttribute("emps", emps);
            request.getRequestDispatcher("Outcome.jsp").forward(request, response);
    }

  
}
