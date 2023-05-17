package com.zhenghou.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * http请求下载图片
 *
 * */
public class HttpUtils1 {

    //下载图片方法
    public static void imageDownLoad(String url) throws Exception {
        //打开浏览器
        HttpClient httpClient = HttpClients.createDefault();
        //输入网址
        HttpGet httpGet=new HttpGet(url);
        //回车
        HttpResponse response = httpClient.execute(httpGet);
        //解析请求  下载图片返回的是一个byte数组
        byte[] buffer= EntityUtils.toByteArray(response.getEntity());
        //获取当前时间
        long currentTime = System.currentTimeMillis();
        // 文件保存路径
        File file=new File("D:\\下载图片\\"+currentTime+".jpg");
        file.createNewFile();
//        String fileName = "image.jpg";
        //利用输出流将图片写回本地
        FileOutputStream fos = new FileOutputStream(file);
        try{
            fos.write(buffer);
            System.out.println("图片保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String url="https://wallhaven.cc/latest?page=2";
        Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        Elements elements = document.select(".preview");
        int count=0;
        for(Element element:elements){
            String href = element.attr("href");
            Document document1 = Jsoup.connect(href).get();
            Elements elements1 = document1.select("#wallpaper");
            String src = elements1.get(0).attr("src");
            System.out.println(src);
            imageDownLoad(src);
            count++;
            if(count==10){
                break;
            }
        }
    }

}
