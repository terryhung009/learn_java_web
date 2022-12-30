<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/11/26
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="counter" class="Obj.Counter" scope="application"></jsp:useBean>


<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2></h2>
  <% counter.increaseCount();  %>
  <p>Your visitor number: <%= counter.getCount() %> </p>






</body>
</html>
