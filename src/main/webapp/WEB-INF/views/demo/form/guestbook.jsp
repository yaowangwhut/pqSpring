<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Spring Form Validation</title>
	<style type="text/css">
		label { width: 70px; display: inline-block; }
		input, textarea { width: 320px; }
		textarea { height: 100px; }
		.red { color: #f00; }
	</style>
</head>
<body>

<h1>Leave your comment</h1>

<form:form modelAttribute="guestForm" method="post">
  <ul>
    <li><form:label path="name">Name</form:label> : <form:input type="text" path="name" />
      <form:errors path="name" cssClass="red" /></li>
    <li><form:label path="email">Email</form:label> : <form:input type="text" path="email" />
      <form:errors path="email" cssClass="red" /></li>
    <li><form:label path="message">Message</form:label> : <form:textarea path="message" />
      <form:errors path="message" cssClass="red" /></li>
    <li><button>Send</button></li>
  </ul>
</form:form>

</body>
</html>
