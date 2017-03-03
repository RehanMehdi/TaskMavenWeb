<%@include file="home.jsp"  %>
<%@page import="mytask.taskmavenweb.Stdnt"%>
<%@page import="mytask.taskmavenweb.DBQueries" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Student</title>
    </head>
    <body>
        <h1>View Page!</h1>
        
         <div class="container">
             
             <div class="col-sm-3">
                 <h3>Name</h3>
                 <h3>Faculty</h3>
                 <h3>Reg</h3>
                 <h3>Gender</h3>
                 <h3>Age</h3>
             </div>
             <div class="col-sm-9">
                 <h2>${c.name}</h2>
                 <h2>${c.faculty}</h2>
                 <h2>${c.reg}</h2>
                 <h2>${c.gender}</h2>
                 <h2>${c.age}</h2>
             </div>
<!--            <table class="table table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Faculty</th>
                    <th>Reg</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>${c.name}</td>
                    <td>${c.faculty}</td>
                    <td>${c.reg}</td>
                    <td>${c.gender}</td>
                    <td>${c.age}</td>
                    <td class="text-center">
                        <a href="?id=${c.id}" class="btn btn-warning active">Edit</a>
                        <a href="deleteservlet/${c.id}" class="btn btn-danger active">Delete</a>
                        <a href="view/${c.id}" class="btn btn-success active">Detail</a>
                    </td>
                </tr>
               
            </table>-->
        </div>
    </body>
</html>
