<%-- 
    Document   : Outcome
    Created on : 22 May 2024, 8:01:25 PM
    Author     : Desmond
--%>

<%@page import="za.ac.tut.entity.Employee"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>name</td>
                <td>age</td>
                <td>pic</td>
                <td>date Hired</td>
            </tr>  
            
       <%
       List<Employee> emps=(List<Employee>) request.getAttribute("emps");
       
       for(Employee x:emps){
       String name=x.getName();
       Integer age=x.getAge();
       byte[] image=x.getImage();
       Date hireDate=x.getDateHired();
       String imageSrc= "data:image/jpg;base64," + Base64.getEncoder().encodeToString(image);
       %>
       <tr>
       <td><%=name%></td>
       <td><%=age%></td>
       <td><%=imageSrc%></td>
       <td><image src="<%=hireDate%>" alt="image"></td>
       </tr>
        
       
       <%
       }
       %> </table>
       <a href="index.html">home</a>
    </body>
</html>
