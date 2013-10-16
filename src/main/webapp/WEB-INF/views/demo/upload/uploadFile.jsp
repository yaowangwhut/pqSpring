<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring MVC Upload File</title>
    <style type="text/css">
        label {
            width: 70px;
            display: inline-block;
        }

        input, textarea {
            width: 320px;
        }

        textarea {
            height: 100px;
        }

        .red {
            color: #f00;
        }
    </style>
</head>
<body>

<h1>Upload your file</h1>

<form:form modelAttribute="uploadForm" method="post" enctype="multipart/form-data">
    Please select a file to upload : <form:input path="file" type="file" name="file"/>
    <br/>
    <input type="submit" value="upload"/>
    <span><form:errors path="file" cssClass="error"/></span>
</form:form>

</body>
</html>
