<%-- 
    Document   : addNoteList
    Created on : Apr 24, 2023, 8:52:35 PM
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
    <style>
        .noteInput{
            width: 400px;
            height: 400px;
            border: hidden;
        } 
        .fadeIn.first{
            margin-bottom: 30px;
        }
    </style>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <div class="fadeIn first">
                    <h2 style="color: black">Your note!</h2>
                    <br>
                </div>
                <form action="MainController" method="post">
                    <input name="noteTitle" type="text" placeholder="Title">
                    <br><br>
                    <textarea name="noteInfo" class="noteInput" placeholder="description..."></textarea>
                    <input type="hidden" name="action" value="addNote" />
                    <input type="hidden" name="userid" value="${sessionScope.usersession.id}" />
                    <input type="submit" class="fadeIn first" value="Submit" />
                </form>
            </div>
        </div>
    </body>
</html>
