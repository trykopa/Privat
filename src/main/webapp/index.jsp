<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Privat API Test</h1>
    <h3>
        <a href="new">Search ExRate by date</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">Get average rate between two dates</a>

    </h3>
</div>

<div class="container" align="center">
    <table class="table table-bordered table-hover table-condensed" border="1" cellpadding="5">
        <caption><h5>List of Users</h5></caption>
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Country</th>
            <th scope="col">Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.country}" /></td>
            <td>
                <a class="btn btn-primary" href="edit?id=<c:out value='${user.id}' />" role="button">Edit</a>

                &nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-primary" href="delete?id=<c:out value='${user.id}' />">Delete</a>
            </td>

            </td>
        </tr>
        </c:forEach>
    </table>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>

