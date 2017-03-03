<%--<%@page import="mytask.taskmavenweb.Stdnt"%>
<%@page import="mytask.taskmavenweb.DBQueries" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="home.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
        <title>Insert</title>
    </head>
    <body>
<!--        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">Home</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="#">Insert</a></li>
                    <li><a href="load">Load</a></li>
                </ul>
            </div>
        </nav>-->
        <div class="container-fluid">
            <div class="panel panel-warning">
                <div class="panel-heading"><strong>Student Form</strong></div>
                <div class="panel-body" style="padding-left: 10%; padding-right: 10%;">
                    <form method="POST" action="InsertServlet">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="name">Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" placeholder="Enter Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="faculty">Faculty:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="faculty" placeholder="Enter Faculty">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="reg">Reg:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="reg" placeholder="Enter Reg">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="gender">Gender</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="gender">
                                    <option value="" disabled selected>Select Your Gender</option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="age">Age:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="age" placeholder="Enter Age">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6" style='padding-top: 3%; padding-left: 20%;'>
                                <button class="btn btn-warning btn-block active" type="submit">Submit Student Data</button>
                            </div>
                            <div class="col-sm-6" style='padding-top: 3%; padding-right: 20%;'>
                                <button class="btn btn-danger btn-block active" type="reset">Reset Data</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
