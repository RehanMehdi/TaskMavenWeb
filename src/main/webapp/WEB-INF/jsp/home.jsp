<%--<%@page import="mytask.taskmavenweb.Stdnt"%>
<%@page import="mytask.taskmavenweb.DBQueries" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Home Page</title>
        <script src="../../ajax.js" type="text/javascript"></script>
        <script src="../../jquery-1.7.1.js" type="text/javascript"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-static-top navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
                </div>
                <ul class="nav navbar-nav navbar-right">

                    <li><a href="${pageContext.request.contextPath}/create">Insert</a></li>
                    <li><a href="${pageContext.request.contextPath}/load">Load</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="jumbotron text-center">
                <h1>WELCOME</h1>

                <select id="_dropbox1">
                    <option value="" selected="selected" disabled="disabled">Select City</option>
                </select>
                <br><br>
                <select id="_dropbox2">
                    <option value="" selected="selected" disabled="disabled">Select Sub City</option>
                </select>         
            </div>
        </div>
    </body>
</html>
