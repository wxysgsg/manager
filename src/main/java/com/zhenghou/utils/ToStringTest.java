package com.zhenghou.utils;

import com.zhenghou.entity.user;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToStringTest {




    /**
     * public String toString() {
     *         return "user{" +
     *                 "id=" + id +
     *                 ", name='" + name + '\'' +
     *                 ", password='" + password + '\'' +
     *                 ", email='" + email + '\'' +
     *                 '}';
     *     }
     * */
    public static void main(String[] args) throws IOException {

        user u=new user();
        Class aClass = u.getClass();
        Field[] fields = aClass.getDeclaredFields();
        StringBuffer stringBuffer=new StringBuffer();
        int i=0;
        stringBuffer.append("@Override"+"\n");
        stringBuffer.append("public String toString() {"+"\n");
        stringBuffer.append("     "+"return"+"\""+aClass.getName()+"{\""+"+"+"\n");
        for(Field field:fields){
            if(i>=1){
                stringBuffer.append("                "+"\", "+field.getName()+"="+"'\" + "+field.getName()+"+ '\\'' +"+"\n");
            }else {
                stringBuffer.append("                "+"\""+field.getName()+"="+"\""+"+"+field.getName()+"+"+"\n");
            }
            i++;
        }
        stringBuffer.append("                "+"'}';"+"\n");
        stringBuffer.append("}"+"\n");
        System.out.println(stringBuffer);

        File file=new File("C:\\Users\\19026\\Desktop\\java程序\\程序\\manager\\src\\main\\java\\com\\zhenghou\\entity\\user.java");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer classStringBf = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine())!=null){
            classStringBf.append(str+"\n");
        }
        //输出 字节 字符
        classStringBf.insert(classStringBf.length()-3,stringBuffer);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(classStringBf.toString().getBytes());
        fileOutputStream.close();

    }
}
