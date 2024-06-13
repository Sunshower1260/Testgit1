package controller;

import dao.accountDAO;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/add", "/del", "/adjust"})
public class UserManagementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        accountDAO accDAO = new accountDAO();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        boolean success = false;
        String message = "";
        
        switch (action) {
            case "/add":
                success = accDAO.addUser(username, password, role);
                message = success ? "User added successfully" : "Failed to add user";
                break;
            case "/del":
                success = accDAO.deleteUser(username);
                message = success ? "User deleted successfully" : "Failed to delete user";
                break;
            case "/adjust":
                success = accDAO.updateUser(username, password, role);
                message = success ? "User updated successfully" : "Failed to update user";
                break;
        }
        
        response.sendRedirect("admin.jsp?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }
}
