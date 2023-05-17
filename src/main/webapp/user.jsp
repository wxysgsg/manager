<%@ page import="com.zhenghou.dao.BaseDao" %>
<%@ page import="com.zhenghou.entity.user" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 19026
  Date: 2023/4/24
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
el表达式  取Attribute中的值  空不报错  取值顺序：当前页面，request,session,application
jstl标签

-->
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>

    <div>${currentuser.name}</div>
    <a href="adduser.jsp">添加</a>

    <div>
        <form method="post" action="">
            <input id="userName" type="text" name="userName" onkeyup="userNameQuery()">
            <input type="submit" value="查询">
            <div id="tips" style="border: 1px solid gray;width:175px;position: relative; left: -26px ; display: none">

            </div>
        </form>
    </div>
    <script src="js/jquery-1.8.3.min.js"></script>
  <script>
      // //方式一  js原生写法
      // function userNameQuery(){
      //     let userNameVal=document.getElementById("userName").value;
      //     console.log(userNameVal);
      //     let xmlRequest=new XMLHttpRequest();
      //     xmlRequest.open("get","userNameQuery.do?userName="+userNameVal,true);
      //     xmlRequest.send();
      //     xmlRequest.onreadystatechange=function (){
      //         //接收字符串
      //         let responseText = xmlRequest.responseText;
      //         //转换成json对象
      //         let jsonObj = JSON.parse(responseText);
      //         let tipsDiv=document.getElementById("tips");
      //         let html="";
      //         for(let i=0;i<jsonObj.length;i++){
      //             html+="<span  style=\"margin-left: -80px\">"+jsonObj[i].name+"</span><br/>";
      //             console.log("接收到java后台返回的值："+jsonObj[i].name);
      //         }
      //         tipsDiv.innerHTML=html;
      //         tipsDiv.style.display="block";
      //     }
      // }

      //方式二  JQuery  ajax
      function userNameQuery(){
          let userNameVal=$("#userName").val();
          //  let userNameVal=document.getElementById("userName").value;
          $.ajax({
              url:"userNameQuery.do?userName="+userNameVal,
              type:"get",
              success:function (result){
                  console.log(result)
                  let jsonObj=JSON.parse(result);
                  let tipsDiv=$("#tips");
                  //  let tipsDiv=document.getElementById("tips");
                  let html="";  //json格式
                  for(let i=0;i<jsonObj.length;i++){
                     html+="<span  style=\"margin-left: -80px\">"+jsonObj[i].name+"</span><br/>";
                     console.log("接收到java后台返回的值："+jsonObj[i].name);
                  }
                  tipsDiv.html(html);
                  tipsDiv.show();
              },
              error:function (result){

              }
          });

      }
  </script>


    <table border="1">
        <tr>
            <td>
                id
            </td>
            <td>
                name
            </td>
            <td>
                password
            </td>
            <td>
                email
            </td>
            <td>
                操作
            </td>
        </tr>

<%--        <%--%>
<%--            //接收对象--%>
<%--            Object list = session.getAttribute("list");--%>
<%--            List<user> list1 =(List<user>)list;--%>
<%--            for(user u:list1){--%>
<%--                request.setAttribute("u",u);--%>
<%--        %>--%>
        <c:forEach var="u" items="${list}">

        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>
                <c:if test="${u.password==111}">
                    会员密码
                </c:if>
                <c:if test="${u.password!=111}">
                     普通密码
                </c:if>
            </td>
            <td>${u.email}</td>
            <td> <a href="updAction.do?id=${u.id}">更新</a>
                <a href="delAction.do?id=${u.id}">删除</a>
            </td>
        </tr>

        </c:forEach>

<%--        <%--%>
<%--            }--%>
<%--        %>--%>
    </table>

    <span>总条数:${count}</span><span>总页数:${totalPage}</span><span>当前页数:${currentPage}</span>
    <a href="userAction.do?currentPage=${currentPage-1}">上一页</a>
    <a href="userAction.do?currentPage=${currentPage+1}">下一页</a>

    <%
        Object vistCountObj = application.getAttribute("vistCount");

        if(vistCountObj!=null){
            int vistCount=(int) vistCountObj;
            vistCount++;
            application.setAttribute("vistCount",vistCount);
        }else {
            //不存在
            application.setAttribute("vistCount",1);
        }

    %>
    <div>浏览量：${vistCount}</div>
    <div>在线用户量：${onlineCount}</div>
    <a href="logOut.do">退出登录</a>
</center>
</body>
</html>
