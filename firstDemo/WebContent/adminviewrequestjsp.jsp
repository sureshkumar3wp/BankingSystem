<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "bs";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
<p align="center"><font><strong>Customers applied for changing details</strong></font></p>
</tr>
<tr bgcolor="#A52A2A">
<td><b>Acc No</b></td>
<td><b>Name</b></td>
<td><b>Email</b></td>
<td><b>Address</b></td>
<td><b>Country</b></td>
<td><b>State</b></td>
<td><b>City</b></td>
<td><b>Mobile</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM rtemplate";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getInt("accno") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("country") %></td>
<td><%=resultSet.getString("state") %></td>
<td><%=resultSet.getString("city") %></td>
<td><%=resultSet.getString("mobile") %></td>


</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>







<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
<p align="center"><font><strong>Customers of their existing Record</strong></font></p>
</tr>
<tr bgcolor="#A52A2A">
<td><b>Acc No</b></td>
<td><b>Name</b></td>
<td><b>Email</b></td>
<td><b>Address</b></td>
<td><b>Country</b></td>
<td><b>State</b></td>
<td><b>City</b></td>
<td><b>Mobile</b></td>


<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="select * from user_reg where accno IN(select accno from rtemplate);";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getInt("accno") %></td>
<td><%=resultSet.getString("fname") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("country") %></td>
<td><%=resultSet.getString("state") %></td>
<td><%=resultSet.getString("city") %></td>
<td><%=resultSet.getString("mobile") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>

</table>
</head>
<body>



<form action="AdminviewerInfo" method ="post">
<pre>
<h3>Enter the Account Number <input type="text" name="accno"></h3>
<button name="action" style="background-color:green;" value ="Approve">APPROVE</button>   <button name="action" style="background-color:red;"  value ="Reject" >REJECT  </button>


</pre>
</form>
</body>
</html>