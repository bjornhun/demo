package com.example.demo.aspect;

import com.example.demo.enitity.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("@annotation(requestMapping)")
    public void logBeforeAllMethods(JoinPoint joinPoint, RequestMapping requestMapping) {
        String method = requestMapping.method()[0].name();
        String path = requestMapping.value()[0];
        log.info("Request received: {} {}", method, path);

        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (!args.isEmpty()) {
            args.forEach(a -> {
                if (a.getClass().equals(Long.class)) {
                    log.info("Id: " + a.toString());
                }
                if (a.getClass().equals(Person.class)) {
                    log.info("Payload: " + a.toString());
                }
            });
        }
    }

}
