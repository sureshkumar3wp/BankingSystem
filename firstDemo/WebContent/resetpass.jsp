<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="resetpass" method="post">
<h1>BEST BUY BANKING</h1>
<h3>HERE YOU CAN CHANGE PASSWORD</h3>
<pre>

Enter your username     <input type="text" name="uname">

Enter the otp           <input type="text" name="otp">
<form action="resetpass" method="get">
<button name="action" value ="generate_otp">generate_otp</button>
</form>
Enter your new password  <input type="password" name="newpass">

<button name="action" value ="change">Change password</button>




</pre>

</form>
</body>
</html>