<%-- 
    Document   : account_information
    Created on : Apr 24, 2023, 3:15:47 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="css/noteList.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Account Information</title>
    </head>
    <style>
        body{
            font-family: monospace;
        }

    </style>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <h2 style="color: red; margin-top: 20px;">Account Information</h2>
                <form action="MainController" method="POST">
                    <h4 style="font-weight:bold;">Fullname</h4> <input type="text" name="txtFullname" value="${requestScope.object.fullname}" readonly /><br/>
                    <h4 style="font-weight:bold;">Username</h4> <input type="text" name="txtUsername" value="${requestScope.object.username}" readonly/><br/>
                    <h4 style="font-weight:bold;">Password</h4> <input type="password" name="txtPassword" value="${requestScope.object.password}" readonly/><br/>
                    <h4 style="font-weight:bold;">Email</h4><input type="text" name="txtEmail" value="${requestScope.object.email}" readonly/><br/>
                    <br/>
                    <input type="hidden" name="id" value=${requestScope.object.id} />
                    <input type="hidden" name="action" value="edit_info" />
                    <input class="fadeIn fourth" style="margin-bottom: 5px; margin-top: -15px;" type="submit" value="Update Information" />
                </form>
                <form action="MainController">
                    <input type="hidden" name="id" value=${sessionScope.usersession.id} />
                    <input type="hidden" name="action" value="delete" />
                    <input class="fadeIn fourth" style="margin-bottom: 25px;" type="submit" value="Delete Account" />
                </form>
                <p style=""><a href='MainController?action='>Logout</a>|<a href='MainController?action=Return'>Back</a></p>
            </div>
        </div>
    </body>
</html>
