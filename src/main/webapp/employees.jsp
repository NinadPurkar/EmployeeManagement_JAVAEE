<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Employees</title></head>
<body>
    <h2>Employee List</h2>
    <table border="1">
            <tr>
                <th>Name</th>
                <th>Department</th>
                <th>Email</th>
            </tr>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.department}</td>
                    <td>${emp.email}</td>
                </tr>
            </c:forEach>
        </table>

    <a href="index.jsp">Add More Employees</a>
</body>
</html>
