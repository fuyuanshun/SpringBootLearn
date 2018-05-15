<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改音乐信息</title>
</head>
<body>
    歌曲信息:
    <table>
        <tr>
            <th>歌曲id</th>
            <th>歌曲名称</th>
            <th>歌曲链接</th>
        </tr>
        <tr>
            <td>${music.id}</td>
            <td>${music.name}</td>
            <td>${music.link}</td>
        </tr>
    </table>

    修改信息:
    <form action="/updateMusicDeal" method="post">
        <input type="hidden" value="${music.id}" name="id">
        <span>歌曲名称:</span>
        <input type="text" id="name" name="name" />
        <span>歌曲链接:</span>
        <input type="text" id="link" name="link" />
        <input type="submit" value="提交修改" />
    </form>
</body>
</html>
