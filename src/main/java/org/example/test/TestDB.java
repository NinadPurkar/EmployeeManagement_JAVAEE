package org.example.test;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB
{
    public static void main (String gg[])
    {
        try {
            Connection con = DBUtil.getConnection();
            System.out.println("Connection successfull !");

            // Create a statement
            Statement stmt = con.createStatement();

            // Test query for user Table

            ResultSet rs = stmt.executeQuery("Select * from users");
            System.out.println("User Table:");
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("UserName: " + rs.getString("username"));
                System.out.println("password: " + rs.getString("password"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
