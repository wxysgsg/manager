package com.zhenghou.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.*;
import java.io.IOException;

public class ChatGptTest {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        //打开浏览器
        HttpClient httpClient = HttpClients.createDefault();
        System.out.println("聊天开始：");
        do{
            System.out.print("用户：");
            String question=sc.next();
            //输入网址
            HttpGet httpGet=new HttpGet("http://192.168.6.239:8080/stu_manager_war_exploded/ChatGptServlet?question="+question);
            //回车
            HttpResponse response = httpClient.execute(httpGet);
            //解析返回的内容
            String respText = EntityUtils.toString(response.getEntity());
            System.out.print("机器人：");
            System.out.println(respText);
        }while (true);

    }
}
