<%-- 
    Document   : index
    Created on : Apr 24, 2023, 4:57:17 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>TODO write content</div>
        
        
        <form action="MainController">
                    <input type="submit" value="logout" />

        </form>
        
        <form action="MainController"  method="POST">
            
            <h1>Aloo</h1>
            <h2>${sessionScope.usersession.id}</h2>
            <h2>${sessionScope.usersession.username}</h2>
            
            <input type="hidden" name="id" value=${sessionScope.usersession.id} />
            <input type="hidden" name="action" value="account_info" />
            <input type="submit" value="Personal Information" />
        </form>
    </body>
    </body>
</html>
