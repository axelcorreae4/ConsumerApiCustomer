package com.ace.api.ConsumerApiCustomer.configs;

import com.ace.api.ConsumerApiCustomer.ConsumerApiCustomerApplication;
import com.ace.api.ConsumerApiCustomer.component.consumerApi.ConsumerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlApiConfig {
    @Value("${url.api.fake}")
    private String urlFakeApi;

    private final Logger log = LoggerFactory.getLogger(ConsumerApiCustomerApplication.class);


    @Bean
    public ConsumerApi consumerApi() {
        log.error("url de la api: "+ urlFakeApi);
        return new ConsumerApi(urlFakeApi);
    }
}
