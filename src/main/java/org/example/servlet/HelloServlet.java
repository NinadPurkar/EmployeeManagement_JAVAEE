package org.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException
    {
        //at first i tried to return simple text and print
        //rsp.setContentType("text/html");
        //rsp.getWriter().println("<h1> Hello Java EE Project ! </h1>");

        // Now returning jsp page. Using RequestDispatcher to forward the req to jsp page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
        dispatcher.forward(req, rsp);
    }
}
