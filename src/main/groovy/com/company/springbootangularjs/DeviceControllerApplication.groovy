package com.company.springbootangularjs

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@CompileStatic
@SpringBootApplication
class DeviceControllerApplication {

    static void main(String[] args) throws Exception {
        SpringApplication.run(DeviceControllerApplication, args)
    }

}
