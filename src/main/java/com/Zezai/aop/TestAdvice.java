package com.Zezai.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect//告诉Spring这是切面
public class TestAdvice  {
    @Pointcut("execution(int com.Zezai.dao.impl.bookDaoImpl.daoAction3(..))")  //定义切入点,指定在哪个方法那执行
    private void pt1(){}

    @Pointcut("execution(void com.Zezai.dao.Dao.daoAction4(..))")  //定义切入点,指定在哪个方法那执行
    private void pt2(){}

    @Pointcut("execution(void com.Zezai.dao.Dao.daoAction2(..))") //定义切入点,指定在哪个方法那执行
    private void pt3(){}

    @Around("pt1()")   //表示在切入点方法执行前执行
    public Object around1(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("before......");    //将想要赋予的方法单独做成一个通知
        Object a=pjp.proceed();                   //表示在此处执行原方法
        System.out.println(a);
        System.out.println("after.......");
        return a;
    }

    @Around("pt2()")
    public void around2(ProceedingJoinPoint pjp)throws Throwable{
        Signature signature=pjp.getSignature();//signature签名对象里储存了原始方法的各种信息,可以通过get***方法获取相关信息
        String TypeName = signature.getDeclaringTypeName();//获取原始方法的所在的类位置
        String MethodName=signature.getName();//获取原始方法的名字
        long time1=System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            pjp.proceed();                   //表示在此处执行原方法
        }
        long time2=System.currentTimeMillis();
        long time=time2-time1;
        System.out.println("执行万次"+MethodName+"接口所需要的时间:"+time+"ms"+"---->位置："+TypeName);   //欲描述执行具体的哪一个接口,需要调用pjp的签名方法
        //注意:当前测试的接口效率只是理论值,与实际有偏差
    }

    @Before("pt3()")   //表示在切入点方法执行前执行
    public void before(JoinPoint jp)  {
        //获取原始方法参数值(数组)
        Object[] args=jp.getArgs();
        System.out.println(Arrays.toString(jp.getArgs()));
        System.out.println("before.....");
    }

    @Around("pt3()")
    public void around3(ProceedingJoinPoint pjp)throws Throwable{
        //System.out.println("around begin");
        Object[] args=pjp.getArgs();
        //同时,通过Around注解,我们可以实现对方法执行前的参数和执行后方法的返回值进行处理(修改),使程序更健壮(很像过滤器)
        Object a=pjp.proceed(args);     //先获取参数,然后填入原始方法中再执行
        //System.out.println("around success");
    }
}

