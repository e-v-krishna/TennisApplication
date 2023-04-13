package com.test.tennis.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* The Swagger2Config helps to access the Swagger UI.
* url : http://localhost:8080/swagger-ui/index.html#/
*
* @author  Venkata Krishna
*/
@Configuration
@RequiredArgsConstructor
public class Swagger2Config {
   

    @Bean
    public OpenAPI apiEndpointsInfo() {
        Info info = new Info()
                .title("Tennis Application")
                .description("Tennis Application")
                .version("1.0");

        return new OpenAPI().info(info);
    }
}
