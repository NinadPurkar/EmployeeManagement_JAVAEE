<%@ page import="org.example.model.Employee" %>
<%
    Employee emp = (Employee) request.getAttribute("employee");
%>
<html>
<body>
<h2>Update Employee</h2>
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
