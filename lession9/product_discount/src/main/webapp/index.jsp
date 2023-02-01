<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/display-discount" method="post">
    <input type="text" name="description" placeholder="description"><br><br>
    <input type="text" name="price" placeholder="price"><br><br>
    <input type="text" name="discount-percent" placeholder="discount-percent"><br><br>
    <input type="submit" name="submit" value="Calculate Discount">
</form>
</body>
</html>