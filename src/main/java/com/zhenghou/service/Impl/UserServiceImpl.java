package com.zhenghou.service.Impl;

import com.zhenghou.dao.BaseDao;
import com.zhenghou.entity.user;
import com.zhenghou.service.UserService;

import java.util.List;
/**
 * 存放方法  实现业务层逻辑
 * */
public class UserServiceImpl implements UserService {

    BaseDao baseDao=new BaseDao();
    public user getUser(String name){
        String sql="select * from user where name=?";
        user u = baseDao.selectOne(user.class, sql, name);
        return u;
    }

    public List<user> getList(int currentPage,int pageSize){
        int startRow=(currentPage-1)*pageSize;
        String sql="select * from user limit ?,?";
        List<user> list= baseDao.selectList(user.class,sql,startRow,pageSize);
        return list;
    }

    public int getCount(){
        String sql1="select count(1) from user";
        //当前条数
        int count = baseDao.selectCount(sql1);
        return count;
    }

    public void addUser(user u){
        String sql="insert into user (id,name,password,email) values (?,?,?,?)";
        baseDao.executeUpdate(sql,u.getId(),u.getName(),u.getPassword(),u.getEmail());
    }

    public void delUser(int id){
        String sql="delete from user where id=?";
        BaseDao baseDao=new BaseDao();
        int i = baseDao.executeUpdate(sql, id);
        System.out.println(i);
    }

    public user updUser(int id){
        String sql="select * from user where id=?";
        user user = baseDao.selectOne(user.class, sql, id);
        return user;
    }

    public void updUser1(user u){
        String sql="update user set name=?,password=?,email=? where id=?";
        baseDao.executeUpdate(sql,u.getName(),u.getPassword(),u.getEmail(),u.getId());
    }







}
