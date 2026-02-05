package com.example.todoapispring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger; // imp for logger
import org.slf4j.LoggerFactory; //imp for logger


@Aspect
@Component

public class TimeMonitorAspect {
    private static final Logger logger =
            LoggerFactory.getLogger(TimeMonitorAspect.class); //slf4j

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

            logger.error("Something went wrong during execution", e); //


        } finally {
            long end = System.currentTimeMillis(); // end

            long totalExecutionTime = end - start ;

            logger.info("Total Execution Time is {} ms", totalExecutionTime);
        }


    }
}
