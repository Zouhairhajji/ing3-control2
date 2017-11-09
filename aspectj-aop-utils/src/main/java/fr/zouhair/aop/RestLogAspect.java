package fr.zouhair.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * An aspect class for logging all routes
 *
 * @author Gokan EKINCI
 */
@Component
@Aspect
@Log
public class RestLogAspect {

    @Pointcut("@annotation(fr.zouhair.annotations.TryAgain)")
    public void tryAgainAnnot() {
    }

    @AfterThrowing(pointcut = "@annotation(fr.zouhair.annotations.TryAgain)", throwing = "ex")
    public void errorInterceptor(Exception ex){
        System.out.println("EXCEP : " + ex.getCause().getMessage());;
    }

    @Around("tryAgainAnnot() && execution(* *(..))")
    public Object restLog(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("COCOU");

        return joinPoint.proceed();

    }
}
