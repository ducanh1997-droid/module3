<%--
  Created by IntelliJ IDEA.
  User: Kho may tinh HN
  Date: 2/5/2023
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Category</h1>
<a href="/products">Back to home</a><br>
<a href="/products?action=create&object=category">Create new product</a><br>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th colspan="2">Action</th>
    </tr>
    <%--    dùng c:forEach để render dữ liệu của list--%>
    <c:forEach var="c" items='${requestScope["categories"]}'>
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
                <%--      <td>${p.getCategory().getName()}</td>--%>
<%--            <td><a href="/products?action=update&object=category&id=${c.id}">--%>
<%--                <button>Update</button>--%>
<%--            </a></td>--%>
<%--            <td><a href="/products?action=delete&object=category&id=${c.id}">--%>
<%--                <button>Delete</button>--%>
<%--            </a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
