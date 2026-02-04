package com.example.todoapispring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
@Component

public class TimeMonitorAspect {
    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint){
        //business logic
        // this logic is getting executed before if we define Before after if we define After and both before and after if we define Around
//        System.out.println("Login Time");
        long start = System.currentTimeMillis(); // start time of the code

        //execute the join point
        try{

            //execute the join point
            joinPoint.proceed();
        } catch (Throwable e) {

            System.out.println("Something went wrong during the execution");

        } finally {
            long end = System.currentTimeMillis(); // end

            long totalExecutionTime = end - start ;

            System.out.println("Total Time of Execution Is " + totalExecutionTime + "ms..");
        }


    }
}
