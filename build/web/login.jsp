<%-- 
    Document   : templet
    Created on : Apr 24, 2023, 8:21:07 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"href="css/noteList.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->

                <!-- Icon -->
                <div class="fadeIn first">
                    <h4>LOGIN</h4>
                    <br>
                </div>

                <!-- Login Form -->
                <form action="MainController" method="POST">
                    <input type="text" id="login" class="fadeIn second" name="txtUsername" placeholder="Username">
                    <input type="password" id="password" class="fadeIn third" name="txtPassword" placeholder="Password">
                    <br>
                    <input type=hidden name="action" value="sign_in">
                    <input type="submit" class="fadeIn fourth" value="Log In">
                </form>

                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <a class="underlineHover" href="sign_up.jsp">Don't Have An Acoount? Sign Up Here</a>
                </div>

            </div>
            <div style="color: white; padding-top: 2px; display: flex;">
                <p>Developed by Bo Minh Lap Trinh/</p><a href="aboutus.jsp"> About us</a>
            </div>
        </div>
    </body>
</html>
