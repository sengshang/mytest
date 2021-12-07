<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 王申鹏--%>
<%--  Date: 2021-11-26--%>
<%--  Time: 16:41--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>&ndash;%&gt;--%>
<%--<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; charset=UTF-8" %>--%>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>登录(首页)</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  <h2>欢迎来到XXX系统</h2>--%>
<%--<form class="loginForm" action="${pageContext.request.contextPath}/user/login">--%>
<%--  用户名<input type="text" name="username"/></br>--%>
<%--  密码<input type="text" name="pwd"/></br>--%>
<%--  <input type="submit" value="text">--%>
<%--</form>--%>

<%--  </body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <script type="text/javascript">
        /* if(top.location!=self.location){
              top.location=self.location;
         } */
    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市订单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/user/login"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${error }</div>
            <div class="inputbox">
                <%--@declare id="user"--%><label for="user">用户名：</label>
                <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <%--@declare id="mima"--%><label for="mima">密码：</label>
                <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>
        </form>
    </section>
</section>
</body>
</html>

