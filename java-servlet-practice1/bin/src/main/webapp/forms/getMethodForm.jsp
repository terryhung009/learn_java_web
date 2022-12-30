<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/11/25
  Time: 00:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8082/formHandling" method="get">
    <label>Book Name:</label>
    <input type="text" name="name">
    <br>
    <label>Price:</label>
    <input type="number" name="price">
    <br>
    <label>Author:</label>
    <input type="text" name="author">
    <br>
    <input type="submit" value="submit">



</form>

</body>
</html>
