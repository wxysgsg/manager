<%@ page import="com.zhenghou.entity.user" %><%--
  Created by IntelliJ IDEA.
  User: 19026
  Date: 2023/4/24
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>
    hello
  </title>
</head>

<body>
<center>
  <h1>添加页面</h1>
  <form id="form1" action="addAction.do" method="get">
    <table border="1">
      <tr>
        <td>编号</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="id" name="id"> </td>
      </tr>
      <tr>
        <td>姓名</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="name" name="name"> </td>
      </tr>
      <tr>
        <td>密码</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="password" name="password"> </td>
      </tr>
      <tr>
        <td>邮箱</td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input id="email" name="email"> </td>
      </tr>
      <tr>
        <td><input type="submit" value="添加"></td>
        <%--    input 表单元素 id-->js  name-->java     --%>
        <td><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form>


  <script src="js/jquery-1.8.3.min.js"></script>
  <script>
    $("#form1").submit(function () {
      //以ajax方式请求提交
          $.ajax({
              url:"addAction.do",
              type:"post",
              data:$("#form1").serialize(),
              success:function (result){
                 //控制台打印true
                 // console.log(result);
                 if(result=="true"){
                   alert("添加成功");
                   document.location.href="userAction.do";
                 }
              },
              error:function (result){
                alert("添加失败");
              }
          });

      return false;
    });



  </script>


</center>
</body>

</html>