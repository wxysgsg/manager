<%@ page import="com.zhenghou.entity.user" %><%--
  Created by IntelliJ IDEA.
  User: 19026
  Date: 2023/4/24
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--  //先获取对象--%>
<%--  user user = (com.zhenghou.entity.user)session.getAttribute("user");--%>
<%--%>--%>
<center>
  <h1>更新页面</h1>
  <div>${currentuser.name}</div>
  <form action="updAction1.do" method="get">
    <table>
      <tr>
        <td>编号</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="id" name="id" value="${user.id}"> </td>
      </tr>
      <tr>
        <td>姓名</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="name" name="name" value="${user.name}"> </td>
      </tr>
      <tr>
        <td>密码</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="password" name="password" value="${user.password}"> </td>
      </tr>
      <tr>
        <td>邮箱</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="email" name="email" value="${user.email}"> </td>
      </tr>
      <tr>
        <td><input type="submit" value="更新"></td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form>
</center>
</body>
</html>
