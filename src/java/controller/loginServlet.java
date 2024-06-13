package controller;

import dao.accountDAO;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.account;

@WebServlet(urlPatterns = {"/login", "/signin"})
public class loginServlet extends HttpServlet {

    protected void loginMethod(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            accountDAO accDAO = new accountDAO();
            account acc = accDAO.checkLogin(username, password);
            if (acc == null) {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", acc);

                if ("admin".equals(acc.getRole())) {
                    response.sendRedirect("admin.jsp");
                } else {
                    response.sendRedirect("welcome.jsp");
                }
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "An error occurred while logging in. Please try again later.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loginMethod(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loginMethod(request, response);
    }
}
