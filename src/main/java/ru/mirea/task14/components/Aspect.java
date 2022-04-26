package ru.mirea.task14.components;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("within(ru.mirea.task14.services.*)")
    public void allServiceMethods() {
    }

    @Around("allServiceMethods()")
    public Object getExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("Execution time for " +className+"."+methodName+": "+ stopWatch.getTotalTimeMillis() + "ms");
        }

    }

}
