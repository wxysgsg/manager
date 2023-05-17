package com.zhenghou.servlet;

import com.alibaba.fastjson.JSON;
import com.zhenghou.dao.BaseDao;
import com.zhenghou.entity.user;
import com.zhenghou.service.Impl.UserServiceImpl;
import com.zhenghou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/userNameQuery.do")
public class UserNameQueryServlet extends HttpServlet {

    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request只能接收string类型的值
        String name=request.getParameter("userName");
        System.out.println(name);
        //去数据库中查询
        String sql="select * from user where name like concat('%',?,'%')";
        BaseDao baseDao=new BaseDao();
        List<user> userList=baseDao.selectList(user.class,sql,name);
        //方式一  使用循环获取数据库中查找到的数据  使用StringBuffer接收  将字符串写回
//        StringBuffer stringBuffer=new StringBuffer();
//        for(user u:userList){
//            stringBuffer.append(u.getName());
//            stringBuffer.append(",");
//        }
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().write(stringBuffer.toString());

        //方式二  使用json  将list转成String类型的json对象  将json写回
//        只能传字符串  把List<user> userList转换成字符串
//        以JSON格式
//        对象{}  数组[]  属性和属性值 “属性”：“属性值”
//        [{"id":"1",
//          "name":"lisi",
//          "password":"111",
//          "email":"lisi@qq.co"
//        },{"id":"1",
//           "name":"lisi",
//           "password":"111",
//           "email":"lisi@qq.co"
//        }]
        //json用工具包fastjson来导入，不用自己写

        //将对象转换成json字符串
        String json = JSON.toJSONString(userList);
//        String json1="[{\"id\":\"1\",\n" +
//                "         \"name\":\"lisi\",\n" +
//                "         \"password\":\"111\",\n" +
//                "        \"email\":\"lisi@qq.co\"\n" +
//                "       }]";
//       将json字符串转换成java对象
////        List list = JSON.parseObject(json1, List.class);

        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);


    }
}
