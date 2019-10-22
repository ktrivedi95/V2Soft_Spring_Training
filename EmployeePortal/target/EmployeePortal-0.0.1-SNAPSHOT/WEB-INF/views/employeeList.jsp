<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee List Page</title>
	</head>
	<style>
		table {
		  font-family: arial, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}
		
		td, th {
		  border: 1px solid #dddddd;
		  text-align: left;
		  padding: 8px;
		}
		
		tr:nth-child(even) {
		  background-color: #dddddd;
		}
	</style>
	<body>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Middle Name</th>
				<th>EmployeeId</th>
				<th>Date of Birth</th>
				<th>Passport Number</th>
				<th>SSN</th>
				<th>Current Address</th>
				<th>Permanent Address</th>
			</tr>
			<c:if test="${not empty lists}">
				<c:forEach items="${lists}" var="lists">
					<tr>
						<td>${lists.firstName}</td>
						<td>${lists.lastName}</td>
						<td>${lists.middleName}</td>
						<td>${lists.employeeId}</td>
						<td>${lists.dateOfBirth}</td>
						<td>${lists.passportNumber}</td>
						<td>${lists.ssn}</td>
						<c:if test="${not empty lists.employeeAddresses}">
							<c:forEach items="${lists.employeeAddresses}" var="addresses">
								<td>
								${addresses.addressLineOne}
								${addresses.addressLineTwo}
								${addresses.city}
								${addresses.state}
								${addresses.zipcode}
								${addresses.zipfour}
								</td>
								<br>
							</c:forEach>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</body>
</html>