<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!zz" %>
</h1>
<br/>
<a href="/customers">Hello Servlet</a>
<c:out value="${'This is true: 10 > 1 '}" />
</body>
</html>