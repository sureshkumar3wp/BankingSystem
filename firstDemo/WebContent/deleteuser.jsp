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
<form action="deleteuser" method ="post">

<pre>

Enter your user name :<input type="text" name="uname">

                      <input type="submit" value="submit">



</pre>
</form>
</body>
</html>