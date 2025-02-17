package com.dreamlayer.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Inventory Service")
                .description("Details about Inventory Stock Available")
                .version("1.0.0"));
    }
}
