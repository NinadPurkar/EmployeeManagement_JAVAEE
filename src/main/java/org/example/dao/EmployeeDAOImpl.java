package org.example.dao;

import org.example.model.Employee;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO
{
    public void addEmployee(Employee e)
    {
        try
        {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO employees(name, department, email) values (?, ?,?)");

            ps.setString(1,e.getName());
            ps.setString(2,e.getDepartment());
            ps.setString(3,e.getEmail());

            ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateEmployee(Employee e)
    {
        String sql = "Update employees set name=?, department=?, email =? where id=?";
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,e.getName());
            ps.setString(2,e.getDepartment());
            ps.setString(3,e.getEmail());
            ps.setInt(4,e.getId());

            ps.executeUpdate();
        }
        catch (Exception exe)
        {
            exe.printStackTrace();
        }
    }

    public void deleteEmployee(int id)
    {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from employees where id= ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public Employee getEmployeeById(int id)
    {
        Employee emp = null;
        String sql = "Select * from employees Where id = ?";
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                int emp_id = rs.getInt("id");
                String emp_name = rs.getString("name");
                String emp_dept = rs.getString("department");
                String emp_email = rs.getString("email");
               emp = new Employee(emp_id, emp_name, emp_dept, emp_email);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return emp;
    }
    @Override
    public List<Employee> getAllEmployees()
    {
        String sql = "Select * from employees";
        List<Employee> employeelist = new ArrayList<>();
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email")
                );
                employeelist.add(emp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employeelist;
    }
}
