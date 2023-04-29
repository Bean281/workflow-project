<%-- 
    Document   : sign_up
    Created on : Apr 23, 2023, 2:58:10 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="css/noteList.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Sign Up</title>
        <style>
            .h1{
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="wrapper fadeInDown" >
            <div id="formContent">
                <h1 style ="margin: 20px;">Sign Up</h1>
                <form action="MainController" method="POST">
                    <c:set var="errors" value="${requestScope.SIGNUP_ERRORS}"/>
                    <input type="text" name="txtFullname" value="${param.txtFullname}" placeholder="Name..."/><br/>
                    <c:if test="${not empty errors.fullnameLengthError}">
                        <font color="red">
                        ${errors.fullnameLengthError}<br/>
                        </font>
                    </c:if>
                    <input type="text" name="txtEmail" value="" placeholder="Email..."/><br/>
                    <c:if test="${not empty errors.emailValidateError}">
                        <font color="red">
                        ${errors.emailValidateError}<br/>
                        </font>
                    </c:if>


                    <input type="text" name="txtUsername" value="" placeholder="Username..."/><br/>
                    <c:if test="${not empty errors.usernameLengthError}">
                        <font color="red">
                        ${errors.usernameLengthError}<br/>
                        </font>
                    </c:if>
                    <c:if test="${not empty errors.usernameIsExisted}">
                        <font color="red">
                        ${errors.usernameIsExisted}<br/>
                        </font>
                    </c:if>
                    <input type="password" name="txtPassword" value="" placeholder="Password"/><br/>
                    <c:if test="${not empty errors.passwordLengthError}">
                        <font color="red">
                        ${errors.passwordLengthError}<br/>
                        </font>
                    </c:if>
                    <input type="password" name="txtConfirm" value="" placeholder="Confirm Password"/><br/>
                    <c:if test="${not empty errors.confirmNotMatched}">
                        <font color="red">
                        ${errors.confirmNotMatched}<br/>
                        </font>
                    </c:if>
                    <br/>
                    <input type="hidden" name="action" value="sign_up" />
                    <input type="submit" class="fadeIn first" value="Sign Up" />
                </form>
            </div>
        </div>
    </body>
</html>
