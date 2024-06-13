<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.account"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
</head>
<body>
    <h1>Admin Dashboard</h1>
    <%
        account user = (account) session.getAttribute("user");
        if (user != null && "admin".equals(user.getRole())) {
    %>
        <p>Welcome, <%= user.getUsername() %>! You have admin privileges.</p>
        
        <%
            String message = request.getParameter("message");
            if (message != null) {
        %>
            <p><%= message %></p>
        <%
            }
        %>
        
        <h1>Add a user</h1>
        <form action="add" method="post">
            Username: <input type="text" name="username"/><br>
            Password: <input type="password" name="password"/><br>
            Role:     <input type="text" name="role"/><br>        
            <input type="submit" value="add"/>
        </form>
        
        <h1>Delete a user</h1>
        <form action="del" method="post">
            Username: <input type="text" name="username"/><br>      
            <input type="submit" value="del"/>
        </form>
        
        <h1>Adjust a user</h1>
        <form action="adjust" method="post">
            Username: <input type="text" name="username"/><br>
            Password: <input type="password" name="password"/><br>
            Role:     <input type="text" name="role"/><br>        
            <input type="submit" value="adjust"/>
        </form>
    <%
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
