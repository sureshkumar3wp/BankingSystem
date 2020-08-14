<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="right"  style="background-color:#FFFFE0;">
<tr>
<tr><td>Name- </td><td>${name}</td></tr>
<tr><td><a href="http://localhost:8080/firstDemo/logout.jsp">Logout</a></td></tr>
</table>
<form action="Userinfo">
<h2></h2>

<pre>
  
   <h3>Search the user details</h3>         Enter the Accno :<input type="text" name="name" >
          
           <input type="submit" value="search">
         
</pre>


</form>
</body>
</html>