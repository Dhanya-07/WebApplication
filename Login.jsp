<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<style>
		body
		{
			background-color: silver;
		}
		#log {
			background-color: white;
  
  border-style: solid;
  margin: 100px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}
input.invalid
{
  background-color: pink;
  
}
</style>
</head>
<body>
	<form action="LoginServlet" method="post" id="log">
	<div class="lg"><b>Enter UserName:</b>
    <p><input type="text" oninput="this.className = ''" name="username"></p>
  </div>
		<div class="lg"><b>Enter Password:</b>
    <p><input type="password" oninput="this.className = ''" name="password"></p>
  </div>
  <div class="lg">
		<input type="submit" name="login" value="Login">
		</div>
	</form>
<script>
function validateForm() {
	  var x, y, i, valid = true;
	  x = document.getElementsByClassName("lg");
	  y = x[currentTab].getElementsByTagName("input");
	  for (i = 0; i < y.length; i++) {
	    if (y[i].value == "") {
	      y[i].className += " invalid";
	      valid = false;
	    }
	  }
	}
</script>
</body>
</html>
