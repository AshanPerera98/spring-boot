package com.ashan_perera.content_calendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // this annotate that inside this class there are one or more beans
public class WebConfig {

    @Bean // bean annotates the this method will retun a component as the result
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }

}
