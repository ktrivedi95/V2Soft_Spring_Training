<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
	</head>
	<style>
		.inputfield {
			padding: 7px;
		}
	</style>
	<body>
		<div style="text-align: center; padding-top: 10px;">
			<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
				<form:input class="inputfield" path="username" name="username" id="username" placeholder="Username"/> <br><br>
				<form:password class="inputfield" path="password" name="password" id="password" placeholder="Password" /> <br><br>
				<form:button class="inputfield" id="login" name="login">Login</form:button>
			</form:form>
		</div>
	</body>
</html>