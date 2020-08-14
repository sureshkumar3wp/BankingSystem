<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<table align="right"  style="background-color:#FFFFE0;">
<tr>
<td>AccNo- </td><td>${accno}</td></tr>
<tr><td>Name- </td><td>${names}</td></tr>
<tr><td><a href="http://localhost:8080/firstDemo/logout.jsp">Logout</a></td></tr>
</table>
<body>
<h3> To change the details</h3>
<form action="Request" method="post">


<table>
<tr><td>Accno:</td><td><input type="text" name="accno"></td></tr>
<tr><td> Name:</td><td><input type="text" name="fname"></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address"></td></tr>
<tr><td>Country</td><td><input type="text" name="country"></td></tr>
<tr><td>State:</td><td><input type="text" name="state"></td></tr>
<tr><td>City</td><td><input type="text" name="city"></td></tr>
<tr><td>Mobile:</td><td><input type="text" name="mobile"></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>