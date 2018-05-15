<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    if(null != request.getParameter("message")) {
        out.print(request.getParameter("message"));
    }
%>
<html>
<head>
    <title>音乐列表</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css" />
</head>
<body>
    <table class="container" border="1">
        <tr>
            <th>音乐id</th>
            <th>音乐名称</th>
            <th>音乐链接</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${musicList}" var="music">
            <tr>
                <th>${music.id}</th>
                <th>${music.name}</th>
                <th><a href="${music.link}">${music.link}</a></th>
                <th><a href="/deleteMusic?id=${music.id}">删除</a></th>
                <th><a href="/updateMusic?id=${music.id}">修改</a></th>
            </tr>
        </c:forEach>
        <tr>
            <form action="/addMusic" method="post">
                <th></th>
                <th><input type="text" name="name"></th>
                <th><input type="text" name="link"></th>
                <th><input type="submit" value="添加"></th>
            </form>
        </tr>
        <tr>
            <th colspan="4">
                共${totalPage}页
                当前第${currentPage}页
                <a href="/selectMusic?currentPage=1">首页</a>
                <a href="/selectMusic?currentPage=${currentPage-1}">上一页</a>
                <a href="/selectMusic?currentPage=${currentPage+1}">下一页</a>
                <a href="/selectMusic?currentPage=${totalPage}">尾页</a>
            </th>
        </tr>
    </table>

</body>
</html>
