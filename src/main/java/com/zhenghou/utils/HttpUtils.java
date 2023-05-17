package com.zhenghou.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * http请求获取json
 * */
public class HttpUtils {
    public static void main(String[] args) throws Exception {
        //打开浏览器
        HttpClient httpClient = HttpClients.createDefault();
        //输入网址
        HttpGet httpGet=new HttpGet("http://t.weather.itboy.net/api/weather/city/101190101");
        //回车
        HttpResponse response = httpClient.execute(httpGet);
        //解析返回的内容
        String respText = EntityUtils.toString(response.getEntity());
        System.out.println(respText);
        //获取最高温度和最低气温
        //字符串转json对象
        JSONObject jsonObject = JSONObject.parseObject(respText);
        JSONObject data = jsonObject.getJSONObject("data");
        System.out.println("当前温度:"+data.getString("wendu")+"℃");
        JSONArray forecast = data.getJSONArray("forecast");
        String high = forecast.getJSONObject(0).getString("high");
        String low = forecast.getJSONObject(0).getString("low");
        System.out.println("最高温度："+high);
        System.out.println("最低温度:"+low);
        //获取明天的最高温度和最低温度
        String high1 = forecast.getJSONObject(1).getString("high");
        String low1 = forecast.getJSONObject(1).getString("low");
        System.out.println("明天的温度为：");
        System.out.println("最高温度："+high1);
        System.out.println("最低温度:"+low1);




    }
}
