package org.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServlet extends HttpServlet
{
    //first we saved data in local list .
    //private List<Employee> employees = new ArrayList<>();
    // Then we moved to store the data in session object
    // createing req.getSession and storing session there
    // with session.setAttribute(employee)
    // Now we are storing data in database

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action.equals("add"))
        {
            Employee emp = new Employee(
                    req.getParameter("name"),
                    req.getParameter("department"),
                    req.getParameter("email")
            );
            employeeDAO.addEmployee(emp);
            rsp.sendRedirect("employee?action=list");
        }
        else if (action.equals("update"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            Employee emp = new Employee(
                    id,
                    req.getParameter("name"),
                    req.getParameter("department"),
                    req.getParameter("email")
            );
            employeeDAO.updateEmployee(emp);
            rsp.sendRedirect("employee?action=list");
        }
        else if (action.equals("delete"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            employeeDAO.deleteEmployee(id);
            System.out.println("in delete if statement");
            rsp.sendRedirect("employee?action=list");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException
    {
        String action = req.getParameter("action");
        if (action.equals("list"))
        {
            List<Employee> list_employees = employeeDAO.getAllEmployees();
            req.setAttribute("employees", list_employees);
            RequestDispatcher rd = req.getRequestDispatcher("listEmployees.jsp");
            rd.forward(req, rsp);
        }
        else if (action.equals("edit"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            Employee emp = employeeDAO.getEmployeeById(id);
            req.setAttribute("employee", emp);
            RequestDispatcher rd = req.getRequestDispatcher("updateEmployee.jsp");
            rd.forward(req, rsp);
        }
        else if (action.equals("delete"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            employeeDAO.deleteEmployee(id);
            System.out.println("in delete if statement");
            rsp.sendRedirect("employee?action=list");
        }
    }
}
