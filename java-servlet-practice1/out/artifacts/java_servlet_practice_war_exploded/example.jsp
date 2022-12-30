<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/11/25
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  for(int j =0; j<=10;j++) { %>
1 + 2 + 3 + 4 + ... + <%= j %> = <%= addUpTo(j) %>
<br/>

<% } %>





<%!

    private int addUpTo(int n){
        int result =0;
        for(int i = 0;i<=n;i++){
            result += i;
        }
        return result;
    }
%>






</body>
</html>
