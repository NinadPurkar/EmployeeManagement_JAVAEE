<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head><title>Employee Management</title></head>
<body>
    <h2>Welcome to Employee Management System</h2>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="add"/>
        Enter Employee Name: <input type= "text" name= "name"><br>
        Enter Employee Departement: <input type= "text" name = "department"><br>
        Enter Employee Email :  <input type= "text" name= "email"><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>
