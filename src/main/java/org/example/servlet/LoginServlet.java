package org.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "admin123".equals(password))
        {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            rsp.sendRedirect("index.jsp");
        }
        else
        {
            req.setAttribute("error", "Invalid credentials!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, rsp);
        }
    }
}
