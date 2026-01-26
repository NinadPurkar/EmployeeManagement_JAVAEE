<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Employee" %>
<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<html>
<body>
<h2>Employee List</h2>
<a href="addEmployee.jsp">Add New Employee</a>
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
