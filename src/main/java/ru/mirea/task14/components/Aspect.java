package ru.mirea.task14.components;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
   private long startTime;

   @Before("allServiceMethods()")
   public void setStartTime(){
      startTime=System.currentTimeMillis();
   }

   @After("allServiceMethods()")
   public void printTime(){
      long endTime = System.currentTimeMillis();
      log.info("Execution time: "+ (endTime -startTime) + "ms");
   }

   @Pointcut("within(ru.mirea.task14.services.*)")
   public void allServiceMethods(){};


}
