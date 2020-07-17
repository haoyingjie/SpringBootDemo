package com.hyj.demo.entity;

import java.io.Serializable;

public class UserEntity  {
    private Long id;
    private String userName;
    private String passWord;

    public UserEntity(){};



    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity(Long id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString(){
        return "UserEntity{"+
                "id="+id+
                ",userName='"+userName+'\''+
                ",passWord='"+passWord+'\''+
                '}';
    }
}
