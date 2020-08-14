<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>

<body>
<center> <p> BEST BUY BANKING    </p></center>
  <center>   <p>USER LOGIN PAGE!!!!!!!!!</p></center>

<div class="container">

      <div id="login">

        <form action="Login" method ="post">
               
          
          <fieldset class="clearfix">
         
           
            <p><span class="fontawesome-user"></span><input type="text" value="Username"  name="name" onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
            <p><span class="fontawesome-lock"></span><input type="password"  value="Password" name="pass" onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <p>Forgot Password!<a href="http://localhost:8080/firstDemo/resetpass.jsp">Reset here!!</a><span class="fontawesome-arrow-right"></span></p>
            <p><input type="submit" value="submit"></p>

          </fieldset>

        </form>

        <p>Not a member? <a href="http://localhost:8080/firstDemo/register.jsp">Sign up now</a><span class="fontawesome-arrow-right"></span></p>

      </div> <!-- end login -->

    </div>

</body>
</html>