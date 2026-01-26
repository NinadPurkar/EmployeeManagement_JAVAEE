package org.example.test;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.model.Employee;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOTest
{
    public static void main(String gg[])
    {
        try
        {
            Connection con = DBUtil.getConnection();
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();

            // 1 Add Employee
            Employee emp = new Employee("ninad", "IT", "testing@gmail.com");
            employeeDAO.addEmployee(emp);
            System.out.println("Employee ninad added successfully");

            // 2 getAllEmployee
            List<Employee> emp_list = new ArrayList<>();
            emp_list = employeeDAO.getAllEmployees();
            System.out.println("Showing list of employee");
            for(Employee e: emp_list)
            {
                System.out.println(e.getId());
                System.out.println(e.getName());
                System.out.println(e.getDepartment());
                System.out.println(e.getEmail());
                System.out.println(" ");
            }

            // getEmployeeBy id
            Employee e = employeeDAO.getEmployeeById(5);
            System.out.println("Showing Emplooyee by id 5");
            System.out.println(e.getName() + e.getDepartment() + e.getEmail());

            // delete employee
            employeeDAO.deleteEmployee(5);
            System.out.println("deleted employee of id 5");

            // show list of all employee now again

            employeeDAO.updateEmployee(new Employee(1,"Jhone_is_greatman", "IT", "jhon_email.com"));
            System.out.println("updated jhon employee 1 details");
            // 2 getAllEmployee
            List<Employee> emp_list1 = new ArrayList<>();
            emp_list1 = employeeDAO.getAllEmployees();
            System.out.println("Showing list of employee");
            for(Employee employee: emp_list1)
            {
                System.out.println(employee.getId());
                System.out.println(employee.getName());
                System.out.println(employee.getDepartment());
                System.out.println(employee.getEmail());
                System.out.println(" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
