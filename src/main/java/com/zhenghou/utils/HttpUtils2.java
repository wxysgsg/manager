package com.zhenghou.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils2 {
    public static void main(String[] args) throws IOException {
        //打开浏览器
        HttpClient httpClient = HttpClients.createDefault();
        //输入网址
        HttpGet httpGet=new HttpGet("");
        //回车,浏览器执行
        HttpResponse response = httpClient.execute(httpGet);
        //解析浏览器返回的结果
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);

    }
}
