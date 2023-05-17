package com.zhenghou.entity;

public class user {
    private int id;
    private String name;
    private String password;
    private String email;

    public user() {
    }

    public user(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

@Override
public String toString() {
     return"com.zhenghou.entity.user{"+
                "id="+id+
                ", name='" + name+ '\'' +
                ", password='" + password+ '\'' +
                ", email='" + email+ '\'' +
                '}';
     }

}
