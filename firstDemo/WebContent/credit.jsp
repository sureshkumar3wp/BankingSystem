<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>BEST BUY BANKING</h1></center>
<table align="right"  style="background-color:#FFFFE0;">
<tr>
<td>AccNo- </td><td>${accno}</td></tr>
<tr><td>Name- </td><td>${names}</td></tr>
<tr><td><a href="http://localhost:8080/firstDemo/logout.jsp">Logout</a></td></tr>
</table>
<h1>Credit Amount to your account</h1>


<form action="Credit" method ="post">
<pre>
Enter your Account number                 <input type="text" name ="accno">
<h4></h4>
Enter the Account Number transfer from    <input type="text" name ="accno1">
<h4></h4>
Enter the Amount                          <input type="text" name ="amnt">
<h4></h4>
<input type="submit" value ="Add">

</pre>
</form>
</body>
</html>