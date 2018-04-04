<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
</head>
<body>

<!-- include header & menu -->
<%@ include file="_header.jsp" %>


<h3>Create Product</h3>

<p style="color: red;">...</p>

<form method="POST" action="doCreateProduct">
    <table border="0">
        <tr>
            <td>Code</td>
            <td><input type="text" name="code" value="" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input id="submit" type="submit" value="Submit" />
                <a href="productList">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<!-- include footer -->
<%@ include file="_footer.jsp" %>
</body>
</html>