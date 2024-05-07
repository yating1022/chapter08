package com.itheima.demo04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
@Aspect
public class AnnoAdvice {
    @Pointcut("execution(* com.itheima.demo03.UserDaoimpl.*(..))")
    public void poincut(){}


    @Before("poincut()")
    public void before(JoinPoint joinPoint){
        //前置通知
        System.out.println("这是前置通知");
        System.out.println("目标类是：" + joinPoint.getTarget());
        System.out.println(",被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());

    }
    //返回通知
    @AfterReturning("poincut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("这是返回通知，方法不出现异常时调用！");
        System.out.println(",被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    //环绕通知
    @Around("poincut()")
    public Object around (ProceedingJoinPoint point) throws Throwable{
        System.out.println("环绕通知之前的部分");
        Object object = point.proceed();
        System.out.println("这是环绕通知之后的部分！");
        return object;
    }

    //异常通知
    @AfterThrowing("poincut()")
    public void afterException(){
        System.out.println("异常通知");
    }
    //后置通知
    @After("poincut()")
    public void after(){
        System.out.println("这是后置通知");
    }
}
