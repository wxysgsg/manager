package com.zhenghou.other;

import com.zhenghou.entity.user;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Class {
    public static void main(String[] args) throws Exception {
        user u=new user();
        java.lang.Class aClass = u.getClass();
        Object object = aClass.newInstance();
        //获取属性和方法由类获取
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(object,"王旭洋");
        System.out.println(name.get(object));

        Method method = aClass.getDeclaredMethod("getName");
        Object returnObj = method.invoke(object);
        System.out.println(returnObj);

    }
}
