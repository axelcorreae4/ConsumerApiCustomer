package com.ace.api.ConsumerApiCustomer.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Consumo de Legados APi",
                version = "1.0.0",
                description = "Api para consumir legados."
        )
)
public class OpenApiConfig
{
}
