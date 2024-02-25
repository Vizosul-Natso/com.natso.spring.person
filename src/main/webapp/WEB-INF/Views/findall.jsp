<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Persons</title>
</head>
<body>
    <h1>All Persons</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <!-- Add more columns if needed -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.age}</td>
                    <!-- Add more columns if needed -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
