<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<!-- include header & menu -->
<%@ include file="_header.jsp" %>
<h3>Hello: ${user.userName}</h3>

User Name: ${user.userName}<b></b>
<br />
Gender: ${user.gender} <br />

<!-- include footer -->
<%@ include file="_footer.jsp" %>
</body>
</html>