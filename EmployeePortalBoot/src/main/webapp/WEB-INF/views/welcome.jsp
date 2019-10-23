<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome Page</title>
	</head>
	<body style="text-align: center">
		<h1>Welcome ${firstname} ${lastname}</h1>
		<a href="/getEmployeeList">Get Employee List</a><br><br>
		<a href="/countEmployees">Total Number of Employees</a><br><br>
		<a href="/searchEmployee">Search Employee by Attributes</a><br><br>
		<a href="<c:url value="/logout"/>">Logout</a>
	</body>
</html>