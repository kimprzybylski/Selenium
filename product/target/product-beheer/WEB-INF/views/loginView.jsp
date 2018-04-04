<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
        <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<!-- include header & menu -->
<%@ include file="_header.jsp" %>

<h3>Login Page</h3>

<p style="color: red;">..</p>

<form method="POST" action="doLogin">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" value= "" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value= "" /> </td>
        </tr>
        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<p style="color:blue;">User Name: tom, password: tom001 or jerry/jerry001</p>

<!-- include footer -->
<%@ include file="_footer.jsp" %>
</body>
</html>