<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String username = request.getParameter("username");
    System.out.println(username);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spring boot test jsp page</title>
</head>
<body>
Hello Spring boot<%=username%>
</body>
</html>
