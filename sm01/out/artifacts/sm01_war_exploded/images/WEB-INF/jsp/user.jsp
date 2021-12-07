<%--
  Created by IntelliJ IDEA.
  User: 王申鹏
  Date: 2021-12-04
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/upload2.do" enctype="multipart/form-data" method="post">
        上传头像<input type="file" name="image"><br>
        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>
