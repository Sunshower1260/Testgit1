<%-- 
    Document   : index.jsp
    Created on : Jun 10, 2024, 8:25:14 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sign in</h1>
        <form action = "login" method ="post">
            Username: <input type="text" name ="username"/><br>
            Password: <input type="password" name ="password"/><br>
            <input type ="submit" value= "login"/>
        </form>
    </body>
</html>
