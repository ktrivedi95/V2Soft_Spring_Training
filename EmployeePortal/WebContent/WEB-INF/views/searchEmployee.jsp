<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Employee Page</title>
	</head>
	<style>
		.inputfield {
			padding: 5px;
		}
	</style>
	<body>
		<div style="text-align: center; padding-top: 8px;">
			<form:form id="searchEmployeeForm" modelAttribute="employee" action="searchEmployeeProcess" method="post">
				<form:input class="inputfield" path="employeeId" name="employeeId" id="employeeId" placeholder="Employee ID"/> <br><br>
				<form:input class="inputfield" path="dateOfBirth" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth"/> <br><br>
				<form:input class="inputfield" path="firstName" name="firstName" id="firstName" placeholder="First Name"/> <br><br>
				<form:input class="inputfield" path="lastName" name="lastName" id="lastName" placeholder="Last Name"/> <br><br>
				<form:input class="inputfield" path="middleName" name="middleName" id="middleName" placeholder="Middle Name"/> <br><br>
				<form:input class="inputfield" path="passportNumber" name="passportNumber" id="passportNumber" placeholder="Passport Number"/> <br><br>
				<form:input class="inputfield" path="ssn" name="ssn" id="ssn" placeholder="SSN"/> <br><br>
				<form:button class="inputfield" id="searchEmployee" name="searchEmployee">Search</form:button>
			</form:form>
		</div>
	</body>
</html>