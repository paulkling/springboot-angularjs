package com.company.springbootangularjs.resources


import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest

@Slf4j
@ControllerAdvice
abstract class BaseResource {

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Resource not found")
    public void notFound(HttpServletRequest req) {
        log.error("Request: " + req.getRequestURL() + " exception " + exception, exception)
    }


}

