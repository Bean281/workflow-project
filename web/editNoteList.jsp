<%-- 
    Document   : editNoteList
    Created on : Apr 25, 2023, 10:01:10 PM
    Author     : LAPTOP
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
                    <h2 style="color: black">Update note!</h2>
                    <br>
                </div>
                <form action="MainController" method="POST">
                    <input type="hidden" name="action" value="editingNote" />
                    <input name="noteTitle" type="text" placeholder="" value="${param.title}">
                    <input type="hidden" name="noteID" value="${param.id}" />
                    <input type="hidden" name="userID" value="${param.userid}" />
                    <br><br>
                    <textarea name="noteInfo" class="noteInput" placeholder="">${param.noteInfo}</textarea>
                    <input type="submit" class="fadeIn first" value="Update NOW!" />
                </form>
            </div>
        </div>
    </body>
</html>
