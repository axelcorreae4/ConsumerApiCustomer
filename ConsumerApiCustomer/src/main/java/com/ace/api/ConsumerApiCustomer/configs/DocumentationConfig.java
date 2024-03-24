package com.ace.api.ConsumerApiCustomer.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentationConfig {
    final Logger log = LoggerFactory.getLogger(DocumentationConfig.class);
    @Bean
    public OpenAPI configOpenApi(){


        return new OpenAPI()
                .info(new Info()
                        .title("Consumo de Api de un Legado")
                        .version("1.0")
                        .description("Api que consume una Fake Api y proporciona un nuevo endPoint")
                        .termsOfService("https://smartbear.com/terms-of-use/")
                        .license(new License().name("OpenApi 3.0").url("https://springdoc.org/")));
    }
}
