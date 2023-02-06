<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/01/2023
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product Detail</h1>
<h2>Id: ${product.id}</h2>
<h2>Name: ${product.name}</h2>
<h2>Price: ${product.price}</h2>
<h2>Quantity: ${product.quantity}</h2>
<a href="/products"><button>Back to home</button></a>
</body>
</html>
