<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/01/2023
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%--form chỉnh sửa thông tin sản phẩm, action tương ứng có kèm id--%>
<h1>Update form</h1>
<form action="products?action=update&object=product&id=${product.id}" method="post">
  <table>
    <tr>
      <td><label for="name">Name:</label></td>
      <%--            truyền dữ liệu vào input--%>
      <td><input type="text" name="name" id="name" value="${product.name}"></td>
    </tr>
    <tr>
      <td><label for="price">Price:</label></td>
      <td><input type="text" name="price" id="price" value="${product.price}"></td>
    </tr>
    <tr>
      <td><label for="quantity">Quantity:</label></td>
      <td><input type="text" name="quantity" id="quantity" value="${product.quantity}"></td>
    </tr>
    <tr>
      <td><label for="category">Category:</label></td>
      <td>
        <select name="category" id="category">
          <c:forEach  var="c" items='${requestScope["categories"]}'>
<%--              <c:set var = "nameCategory" scope = "session" value = "${product.getCategory().getName()}"/>--%>
<%--            <c:choose>--%>
<%--                  <c:when test="${nameCategory.equals(c.name)}">--%>
<%--                  <option value="${c.name} selected">${c.name}</option>--%>
<%--                  </c:when>--%>
<%--                  <c:otherwise>--%>
<%--                    <option value="${c.name}">${c.name}</option>--%>
<%--                  </c:otherwise>--%>
<%--            </c:choose>--%>
            <option value="${c.name}">${c.name}</option>--%>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <button type="submit">Update</button>
        <a href="/products" style="text-decoration: none">
          <button>Back to home</button>
        </a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
