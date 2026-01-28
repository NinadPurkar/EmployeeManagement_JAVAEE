<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Employee" %>

<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>

<body>
<h1>Employee List</h1>
<p> Welcome, <%= user %>!</p>
<nav>
        <a href="index.jsp">🏠 Home</a> |
        <a href="addEmployee.jsp">➕ Add Employee</a> |
        <a href="logout">🚪 Logout</a>
    </nav>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Department</th><th>Email</th><th>Actions</th></tr>
<% for (Employee e : employees) { %>
<tr>
    <td><%= e.getId() %></td>
    <td><%= e.getName() %></td>
    <td><%= e.getDepartment() %></td>
    <td><%= e.getEmail() %></td>
    <td>
        <a href="employee?action=edit&id=<%= e.getId() %>">Edit</a>
        <a href="employee?action=delete&id=<%= e.getId() %>">Delete</a>
    </td>
</tr>
<% } %>
</table>
</body>
</html>
