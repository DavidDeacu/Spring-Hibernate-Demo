<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>License Demo - Catalog landing page</title>
</head>
<body>

<h1>Catalog - You are logged in as: ${user.username}</h1> 

<form:form action="/LicenseDemo/catalog/processSearch" modelAttribute="student">

First Name: <form:input path="firstName" />
<br><br>
Last Name: <form:input path="lastName"/>
<br><br>
City: <form:select path="city">

<form:options items="${student.listOfCities }" />

</form:select>

<br><br>

<input type="submit" value="Submit" />
</form:form>

</body>
</html>