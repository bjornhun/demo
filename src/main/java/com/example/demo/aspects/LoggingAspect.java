package com.example.demo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before(value = "@annotation(requestMapping)")
    public void logBeforeAllMethods(RequestMapping requestMapping) {
        String method = requestMapping.method()[0].name();
        String path = requestMapping.value()[0];
        log.info("Request received: {} {}", method, path);
    }

}
