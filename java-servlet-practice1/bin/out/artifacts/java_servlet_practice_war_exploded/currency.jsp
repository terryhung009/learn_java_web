<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/11/25
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Obj.Currency"  %>
<%@ page errorPage="error.jsp" %>

<%-- <% ClassName objectName = new ClassName(( %>  --%>
<%--<jsp:useBean id="objectName" class="ClassName" scope="session"> --%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  double jpn = 4.4382;
  double usd = 0.0345;
  double twd = 1;
  double cny = 0.2300;
  int amount = Integer.parseInt(request.getParameter("amount"));
  Currency currency = new Currency(amount);

%>
<h2>美金： <%= amount * usd %></h2>
<h2>日幣： <%= amount * jpn %></h2>
<h2>人民幣： <%= amount * cny %></h2>

<h2>美金： <%= amount * currency.getUsd() %></h2>
<h2>日幣： <%= amount * currency.getJpn() %></h2>
<h2>人民幣： <%= amount * currency.getCny() %></h2>






</body>
</html>
