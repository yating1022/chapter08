package com.itheima.demo01;

import javax.naming.event.ObjectChangeListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Myproxy implements InvocationHandler {
    private UserDao userDao;
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        ClassLoader classLoader = Myproxy.class.getClassLoader();
        Class[] classes = userDao.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader,classes,this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permissions();
        Object obj = method.invoke(userDao,args);
        myAspect.log();
        return obj;
    }
}
