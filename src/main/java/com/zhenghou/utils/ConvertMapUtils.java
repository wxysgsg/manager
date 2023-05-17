package com.zhenghou.utils;

import com.zhenghou.entity.user;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ConvertMapUtils {

    //对象转Map
    public static HashMap<String,Object> objToMap(user u) throws IllegalAccessException {
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        //1.获取对象的所有属性
        Field[] fields = u.getClass().getDeclaredFields();
        for (Field field:fields) {
            //2.开权限
            field.setAccessible(true);
            //3.获取属性名称，获取属性值，存到map中
            hashMap.put(field.getName(),field.get(u));
        }
        return  hashMap;
    }

    //Map转对象
    public static user mapToObj(HashMap<String,Object> map) throws IllegalAccessException {
        user u = new user();
        //1..获取对象所有属性
        Field[] fields = u.getClass().getDeclaredFields();
        for (Field field:fields) {
            //2.开权限
            field.setAccessible(true);
            //3.先获取属性名称（map的key）  根据key获取map的value  field.set(对象，value值)给对象赋值
            field.set(u,map.get(field.getName()));
        }
        return  u;
    }


    public static void main(String[] args) throws IllegalAccessException {
        //1.对象===Map
        user u= new user();
        u.setName("lisi");
        u.setPassword("123");
        HashMap<String,Object> map =  ConvertMapUtils.objToMap(u);
        System.out.println(map);
        //2.Map===对象
        user u1 = ConvertMapUtils.mapToObj(map);
        System.out.println(u1.toString());

    }
}
