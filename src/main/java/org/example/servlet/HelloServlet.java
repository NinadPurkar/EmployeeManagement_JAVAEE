package org.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException
    {
        rsp.setContentType("text/html");
        rsp.getWriter().println("<h1> Hello Java EE Project ! </h1>");
    }
}
