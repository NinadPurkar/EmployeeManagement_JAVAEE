<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management System</title>
    <!-- Link to CSS (you can create style.css later in /css folder) -->
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
    <div class="container">
        <h1>Welcome to Employee Management System</h1>

        <p>Choose an option below to get started:</p>

        <nav>
            <ul>
                <li><a href="employee?action=list">📋 View Employees</a></li>
                <li><a href="addEmployee.jsp">➕ Add Employee</a></li>
                <li><a href="employee?action=search">🔍 Search Employee</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>
