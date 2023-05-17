package com.zhenghou.service;

import com.zhenghou.dao.BaseDao;
import com.zhenghou.entity.user;

import java.util.List;

public interface UserService {

     user getUser(String name);

     List<user> getList(int currentPage,int pageSize);

     int getCount();

     void addUser(user u);

     void delUser(int id);

     user updUser(int id);

     void updUser1(user u);







}
