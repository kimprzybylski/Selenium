<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>

<!-- include header & menu -->
<%@ include file="_header.jsp" %>

<h3>Edit Product</h3>

<p style="color: red;">...</p>

<!-- add JSTL if test to check if product not empty -->

    <form method="POST" action="doEditProduct">
        <input type="hidden" name="code" value="${product.code}" />
        <table border="0">
            <tr>
                <td>Code</td>
                <td style="color:red;"></td>
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
                <td colspan = "2">
                    <input id="submit" type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>


<!-- include footer -->
<%@ include file="_footer.jsp" %>
</body>
</html>