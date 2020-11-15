<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>License Demo - Login Page</title>

<style>
	.error{color:red}
</style>
</head>
<body>

<form:form action="processLogin" modelAttribute="user">

	${loginError}
	
	<br><br>
	Username: <form:input path="username"/>
		<form:errors path="username" cssClass="error" />
	
	<br><br>
	
	Password: <form:password path="password"/>
		<form:errors path="password" cssClass="error" />
	
	<br><br>
	
	<input type="submit" value="Submit"/>

</form:form>

</body>
</html>