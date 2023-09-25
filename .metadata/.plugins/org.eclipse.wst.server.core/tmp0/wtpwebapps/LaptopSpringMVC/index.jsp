<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Laptop Database</h3>


<form action="addShowLaptopServlet">

Enter Laptop ID -<input type="number" name="lid"/><br /><br />
Enter Laptop Make -<input type="text" name="make" /><br /><br />
Enter Laptop Cost -<input type="number" name="cost"/><br /><br />

<input type="submit" name="action" value="Add"/>
<input type="submit" name="action" value="Show"/>

</form>

</body>
</html>