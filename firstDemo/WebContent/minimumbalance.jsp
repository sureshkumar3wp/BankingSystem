<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="minimumbal" method ="post">
<pre>
<center><h1>BEST BUY BANKING</h1></center>
<table align="right"  style="background-color:#FFFFE0;">
<tr>
<tr><td>Name- </td><td>${name}</td></tr>
<tr><td><a href="http://localhost:8080/firstDemo/logout.jsp">Logout</a></td></tr>
</table>
<h4>Click here to search for customer less than minimum balance</h4>

Enter the amount<input type="text" name="amnt">     <button name="action" value ="minimum_balance">Minimum Balance</button>

<h4>Click here to search for Maximum spend user details</h4>

 <button name="action" value ="maximum_spend">Maximum spend</button>

<h4>Click here to search for Minimum spend user details</h4>


<button name="action" value ="minimum_spend">Minimum spend</button>

<h4>Click here to search for Maximum spend in a day user details</h4>

Enter the date<input type="text" name="max_spend_d">    <button name="action" value ="maximum_spend_day">Maximum spend day</button>

<h4>Click here to search for Minimum spend in a day user details</h4>

Enter the date<input type="text" name=  "min_spend_d">     <button name="action" value ="minimum_spend_day">Minimum spend day</button>


</pre>
</form>
</body>
</html>