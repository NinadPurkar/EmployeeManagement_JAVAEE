package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil
{
    private static final String url = "jdbc:mysql://localhost:3306/employee_management";
    private static final String user = "root";
    private static final String password = "Ninad123#";

    public static Connection getConnection() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver"); // load mysql driver
        return DriverManager.getConnection(url, user, password);
    }
}
