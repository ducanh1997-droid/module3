<%--
  Created by IntelliJ IDEA.
  User: Kho may tinh HN
  Date: 2/5/2023
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="products?action=update&object=category&id=${category.id}" method="post">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <%--            truyền dữ liệu vào input--%>
            <td><input type="text" name="name" id="name" value="${category.name}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Update</button>
                <a href="products?action=display&object=category" style="text-decoration: none">
                    <button>Back to home</button>
                </a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
