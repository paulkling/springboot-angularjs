package com.company.springbootangularjs.config

import com.mangofactory.swagger.configuration.SpringSwaggerConfig
import com.mangofactory.swagger.models.dto.ApiInfo
import com.mangofactory.swagger.plugin.EnableSwagger
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@CompileStatic
@EnableSwagger
@Component
@SuppressWarnings('GStringExpressionWithinString')
class SwaggerConfig {

    private static final String DESC = 'A Spring Boot Application'

    @Autowired
    SpringSwaggerConfig springSwaggerConfig

    @Value('${app.name}')
    String appName

    @Bean
    SwaggerSpringMvcPlugin customImplementation() {
        String includePatternStr1 = "^/subjects*.*\$"
        String includePatternStr2 = "^/printrequests*.*\$"
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo())
                .includePatterns(includePatternStr1,includePatternStr2)
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(appName, DESC, null, null, null, null)
    }

}
