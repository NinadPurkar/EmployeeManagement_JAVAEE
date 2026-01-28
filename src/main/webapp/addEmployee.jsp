<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>

<body>
 <h1>Add Employee</h1>
    <p>Welcome, <%= user %>!</p>

    <nav>
        <a href="index.jsp">🏠 Home</a> |
        <a href="EmployeeServlet?action=list">📋 View Employees</a> |
        <a href="LogoutServlet">🚪 Logout</a>
    </nav>

<form action="employee" method="post">
    <input type="hidden" name="action" value="add"/>
    Name: <input type="text" name="name"/><br/>
    Department: <input type="text" name="department"/><br/>
    Email: <input type="text" name="email"/><br/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>