package com.itheima.demo04;

import com.itheima.demo03.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext-Anno.xml");
        UserDao userDao = classPathXmlApplicationContext.getBean("userDao",UserDao.class);
        userDao.update();
        System.out.println();
        userDao.insert();
        System.out.println();
        userDao.delete();
        System.out.println();
        userDao.select();
    }
}
