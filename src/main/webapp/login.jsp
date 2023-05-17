<%--
  Created by IntelliJ IDEA.
  User: 19026
  Date: 2023/4/25
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>

<center>

  <form action="login.do" method="get">
    <table>
      <tr>
        <td>用户名：</td>
        <td><input name="name"></td>
      </tr>

      <tr>
        <td>密码:</td>
        <td><input name="password"></td>
      </tr>

      <tr>
        <td><input type="submit" value="登录"></td>
        <td><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form>

</center>
</body>
</html>
