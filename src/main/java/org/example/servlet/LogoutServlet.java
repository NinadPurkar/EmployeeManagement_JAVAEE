package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.IIOException;
import java.io.IOException;

public class LogoutServlet extends HttpServlet
{
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(false);
        if (session != null)
        {
            session.invalidate();
        }
        rsp.sendRedirect("login.jsp");
    }
}
