package com.Zezai.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CodeCheckAdvice {
    @Pointcut("execution(* com.Zezai.service.Service.CodeCheckService(..))")
    private void pt1(){}

    //@Around("pt1()")
    public Object  CodeCheck(ProceedingJoinPoint pjp) throws Throwable {
       Object[] args=pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            if(args[i].getClass().equals(String.class))
            {
                args[i]= args[i].toString().trim();
            }
        }
        return pjp.proceed(args);
    }
}
