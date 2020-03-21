package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置
 *
 * @author zhigang.xu
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 等同于applicationContext.xml <bean id="" class="">
     *
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
