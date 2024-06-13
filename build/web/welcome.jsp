<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.account"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    <h1>Welcome</h1>
    <%
        account user = (account) session.getAttribute("user");
        if (user != null) {
    %>
        <p>Welcome, <%= user.getUsername() %>!</p>
    <%
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
