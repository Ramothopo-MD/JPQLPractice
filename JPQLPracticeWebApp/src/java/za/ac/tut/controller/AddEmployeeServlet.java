/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.entity.Employee;
import za.ac.tut.entity.EmployeeFacadeLocal;


@MultipartConfig
public class AddEmployeeServlet extends HttpServlet {

   @EJB EmployeeFacadeLocal efl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name=request.getParameter("name");
            Integer age=Integer.parseInt(request.getParameter("age"));
            Part imagePart=request.getPart("picture");
            SimpleDateFormat sm=new SimpleDateFormat("MM/dd/yyyy");
            String dateHired=request.getParameter("dateHired");
            Date dateH=null;
       try {
           
           dateH=sm.parse(dateHired);
           
       } catch (ParseException ex) {
           Logger.getLogger(AddEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        if (imagePart!=null&&imagePart.getSize()>0) {
            InputStream inputStream=imagePart.getInputStream();
            byte[] imageContent=new byte[(int) imagePart.getSize()];
             
            inputStream.read(imageContent);
            
            Employee emp=new Employee(name, age, imageContent, dateH);
            efl.create(emp);
             request.getRequestDispatcher("index.html").forward(request, response);
        }
       
       
       
            
            
    }

}
