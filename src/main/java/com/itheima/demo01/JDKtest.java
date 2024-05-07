package com.itheima.demo01;
import com.itheima.demo01.impl.UserDaoimpl;


public class JDKtest {
    public static void main(String[] args) {
        Myproxy jdkProxy = new Myproxy();
        UserDao userDao = new UserDaoimpl();
        UserDao proxy = (UserDao) jdkProxy.createProxy(userDao);
        proxy.addUser();
        proxy.deleteUser();
    }
}
