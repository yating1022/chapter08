package com.itheima.demo03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao =  classPathXmlApplicationContext.getBean("userDao",UserDao.class);
        userDao.select();
        System.out.println();
        userDao.delete();
        System.out.println();
        userDao.insert();
        System.out.println();
        userDao.update();
        System.out.println();

    }
}
