<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

<!-- include header & menu -->
<%@ include file="_header.jsp" %>
<h3 id="titel">Product List</h3>

<p style="color: red;">...</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td id="code">${product.code}</td>
            <td id="name">${product.name}</td>
            <td id="price">${product.price}</td>
            <td>
                <a href="editProduct?code=${product.code}">Edit</a>
            </td>
            <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <!-- use JSTL to loop your product list
        <tr>
            ...
            <td>
                <a href="editProduct?code=...">Edit</a>
            </td>
            <td>
                <a href="deleteProduct?code=...">Delete</a>
            </td>
        </tr>
    -->
</table>

<a href="createProduct" id="create">Create Product</a>

<!-- include footer -->
<%@ include file="_footer.jsp" %>
</body>
</html>