<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Employee" %>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%
    Employee emp = (Employee) request.getAttribute("employee");
%>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>

<body>
<h1>Update Employee</h1>
    <p>Welcome, <%= user %>!</p>

    <nav>
        <a href="index.jsp">🏠 Home</a> |
        <a href="EmployeeServlet?action=list">📋 View Employees</a> |
        <a href="LogoutServlet">🚪 Logout</a>
    </nav>

<form action="employee" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="<%= emp.getId() %>"/>
    Name: <input type="text" name="name" value="<%= emp.getName() %>"/><br/>
    Department: <input type="text" name="department" value="<%= emp.getDepartment() %>"/><br/>
    Email: <input type="text" name="email" value="<%= emp.getEmail() %>"/><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
