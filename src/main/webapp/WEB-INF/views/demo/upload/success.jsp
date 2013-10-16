<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Form Validation</title>
</head>
<body>
Your message has been submitted.
<div>File Type: ${filetype}</div>
<div>File Name: ${filename}</div>
<div>
    <c:if test="${'.txt' == filetype}">
        Text File Content is :<br/>-----------------start------------------
        <c:forEach var="line" items="${lines}">
            <br/>${line}
        </c:forEach>
    </c:if><br/>-----------------end-----------------</div>
<a href="/upload">Upload another file</a>.
</body>
</html>