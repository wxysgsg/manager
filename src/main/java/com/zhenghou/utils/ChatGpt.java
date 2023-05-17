package com.zhenghou.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ChatGpt {

    public static void main(String[] args) throws IOException {
        HttpHost proxy = new HttpHost("127.0.0.1",4301);

        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectionRequestTimeout(3000)
                .build();
        HttpClient httpClient = HttpClients.createDefault();
        //浏览器输入地址
        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/chat/completions");
        //请求头带参
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization","Bearer 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");
        //请求参数
        String param = "{\n" +
                "                \"model\": \"gpt-3.5-turbo\",\n" +
                "                \"messages\": [{\"role\": \"user\", \"content\": \"AI终将取代人类吗？\"}],\n" +
                "                \"temperature\": 0.7\n" +
                "        }";

        //按回车发请求
        StringEntity stringEntity=   new StringEntity(param,"UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setConfig(requestConfig);
        HttpResponse response = httpClient.execute(httpPost);
        //解析返回的类容
        String respText = EntityUtils.toString(response.getEntity());
        System.out.println(respText);
    }
}
