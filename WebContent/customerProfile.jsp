<%@page import="com.newtechbook.model.Customer"%>
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>

<center><u><h1>Login Sucessfull!!! Welcome :: ${customer.customerId }</h1></u>
<a href="index.jsp">Logout</a>
<br /><br /><br />
<table style="border:5px red solid;">
<tbody>
<tr><td>First Name :</td><td> ${customer.firstName}</td></tr>
<tr><td>Last Name : </td><td>${customer.lastName }</td></tr>
<tr><td>Gender : </td><td> ${customer.gender }</td></tr>
<tr><td>Date of Birth : </td><td>${customer.dob }</td></tr>
<tr><td>Address : </td><td> ${customer.address }</td></tr>
<tr><td>Email ID : </td><td> ${customer.email }</td></tr>
<tr><td>Phone No : </td><td> ${customer.phone }</td></tr>
</tbody>
</table>
</center>
</body>
</html>