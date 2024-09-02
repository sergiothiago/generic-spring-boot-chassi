package com.chassi.generics.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Info info = new Info().title("Generic Project")
                .version("1.0")
                .description("Example using generic project");

        return new OpenAPI()
                .info(info);
    }

}
