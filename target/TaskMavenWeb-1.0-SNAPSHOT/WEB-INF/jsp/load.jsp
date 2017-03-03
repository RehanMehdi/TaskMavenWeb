<%@page import="mytask.taskmavenweb.Stdnt"%>
<%@page import="mytask.taskmavenweb.DBQueries" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="home.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
        <title>Load</title>
    </head>
    <body>
<!--        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">Home</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="create">Insert</a></li>
                    <li><a href="#">Load</a></li>
                </ul>
            </div>
        </nav>-->
        
        <div class="container">
            <table class="table table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Faculty</th>
                    <th>Reg</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="c" items="${list}">
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
                </c:forEach>
            </table>
        </div>
    </body>
</html>
