package com.service;

import com.entity.User;

public interface UserService {
    /**
     * 新增一个用户
     *
     */
    int create(String username,String Password);
    User findByName(String name);

  /*  *//**
     * 根据name删除一个用户高
     * @param username
     *//*
    void deleteByName(String username);

    *//**
     * 获取用户总量
     *//*
    Integer getAllUsers();
    *//**
    *创建一个新表
    */
   /* void createName(String name);

    User findByName(String name);

    User findByNameAndPassword(String name, String password);*/
}
