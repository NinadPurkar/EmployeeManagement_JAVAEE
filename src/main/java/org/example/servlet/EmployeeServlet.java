package org.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServlet extends HttpServlet
{
    //private List<Employee> employees = new ArrayList<>();
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException
    {
        String empName = req.getParameter("empName");
        String empDept = req.getParameter("empDept");
        String empEmail = req.getParameter("empEmail");

        Employee emp = new Employee(empName, empDept, empEmail);

        HttpSession session = req.getSession();
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");

        if (employees == null)
        {
            employees = new ArrayList<>();
        }

        employees.add(emp);

        session.setAttribute("employees",employees);

        //Forwaard to employees.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/employees.jsp");
        dispatcher.forward(req,rsp);
    }
}
