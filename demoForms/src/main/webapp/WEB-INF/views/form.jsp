<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!-- <!Doctype html PUBLIC " -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

    <title>form</title>
</head>
<body>
<h1>${message}</h1>
<h2>Contact</h2>
<form:form method="post" action="addContact.html" modelAttribute="conctact">
    <form:label path="firstname">FirstName</form:label>
    <form:input path="firstname"/>
    <br>
    <hr>


    <form:label path="lastname">lastname</form:label>
    <form:input path="lastname"/>
    <br>
    <hr>
    <form:label path="email">email</form:label>
    <form:input path="email"/>
    <br>
    <hr>
    <form:label path="telephone">phone</form:label>
    <form:input path="telephone"/>
    <br>
    <hr>
    <input type="submit" value="Add Contact">



</form:form>
</body>
</html>
