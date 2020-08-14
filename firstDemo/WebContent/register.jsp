<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">

<center><h1>BEST BUY BANKING</h1></center>
<h2>REGISTRATION FORM</h2>

<table>
<tr><td>First Name:</td><td><input type="text" name="fname"></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
<tr><td>username:</td><td><input type="text" name="uname"></td></tr>
<tr><td>Password:</td><td><input type="password" name="pass"></td></tr>
<tr><td>Confirm Password:</td><td><input type="password" name="cpass"></td></tr>
<tr><td>Date Of Birth</td><td><input type="text" name="dob"></td></tr>
<tr><td>Age:</td><td><input type="text" name="age"></td></tr>
<tr><td>Gender  : </td><td><select name="gender">
<option value=" ">Choose a gender</option>
<option value="MALE">MALE</option>
<option value="FEMALE">FEMALE</option>
<option value="OTHER">OTHER</option>
</select></td>
</tr>
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