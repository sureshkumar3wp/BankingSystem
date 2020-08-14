<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%


%>

</head>
<body>
<center><h1>BEST BUY BANKING</h1></center>

<table align="right"  style="background-color:#FFFFE0;">
<tr>
<td>AccNo- </td><td>${accno}</td></tr>
<tr><td>Name- </td><td>${names}</td></tr>
<tr><td><a href="http://localhost:8080/firstDemo/logout.jsp">Logout</a></td></tr>
</table>
<pre>
<h3>To perform transactions Activities</h3>

To Add amount<a href="http://localhost:8080/firstDemo/credit.jsp">Credit</a>
<h3></h3>
To Remove amount<a href="http://localhost:8080/firstDemo/debit.jsp">Debit</a>
<h3></h3>
<h3>To change the details</h3>

To change to personal details<a href="http://localhost:8080/firstDemo/request.jsp">Click Here!!</a>

<h3>To Delete your Account</h3>
click here to <a href="http://localhost:8080/firstDemo/deleteuser.jsp">delete account</a>



</pre>




</body>
</html>