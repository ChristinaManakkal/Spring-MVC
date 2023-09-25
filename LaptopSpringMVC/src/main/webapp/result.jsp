<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Laptop Details:</h3>
<table border="1">
<tr>
<th>Laptop ID</th>
<th>Laptop Make</th>
<th>Laptop Cost</th>
</tr>


<%
ResultSet rst = (ResultSet) request.getAttribute("laptopResultSet");
while (rst.next()) { 
%>

<tr>
<td><%= rst.getInt("lid") %></td>
<td><%= rst.getString("make") %></td>
<td><%= rst.getDouble("cost") %></td>
</tr>


<% } %>


</table>
</body>
</html>