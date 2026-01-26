package org.example.dao;

import org.example.model.Employee;
import org.example.util.DBUtil;

import java.util.List;

public interface EmployeeDAO
{
    void addEmployee(Employee e);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee e);
    void deleteEmployee(int id);
}
