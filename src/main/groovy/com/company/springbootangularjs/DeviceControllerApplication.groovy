package com.company.springbootangularjs

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer

@CompileStatic
@SpringBootApplication
class DeviceControllerApplication extends SpringBootServletInitializer {

    static void main(String[] args) throws Exception {
        SpringApplication.run(DeviceControllerApplication, args)
    }

}
