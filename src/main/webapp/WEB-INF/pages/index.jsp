<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function myFunction() {
    var x = document.getElementById("registerDiv");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function myFunction1() {
    var x = document.getElementById("userDetailDiv");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
</script>
</head>
<body>
<h1>Welcome</h1>
<br>

<button onclick="myFunction()">Register</button>
<button onclick="myFunction1()">Get User</button>

<div id="registerDiv">
<form action="register" method="post" enctype="multipart/form-data">
Username:<input type="text" name="username" id="username"><br/>
Password:<input type="password" name="password" id="password"><br/>
Photo:<input type="file" name="photo" id="password"><br/>
<input type="submit" value="Register">
</form>
</div>

<div id="userDetailDiv">
<form action="getUser" method="get" enctype="multipart/form-data">
Enter Username to get details:<input type="text" name="username" id="username"><br/>
<input type="submit" value="Get User details">
</form>
</div>

<script type="text/javascript">
window.onload = function(){
	document.getElementById("registerDiv").style.display = "none";
	document.getElementById("userDetailDiv").style.display = "none";
	};
</script>
</body>
</html>