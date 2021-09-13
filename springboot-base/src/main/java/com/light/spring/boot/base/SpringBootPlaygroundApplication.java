package com.light.spring.boot.base;

import com.light.spring.boot.base.config.PlayGroundImmutableProperties;
import com.light.spring.boot.base.config.PlayGroundProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * EnableConfigurationProperties 主动指明配置类，这样就可以注入到spring中
 * 如果是在开发自己独有的内容，可以先注册一个使用@Configuration(proxyBeanMethods = false)注解的bean，
 * 然后在这个bean上添加@EnableConfigurationProperties注解
 * 使用@ConfigurationPropertiesScan也可以去扫描更多的Properties的bean，而不需要一个个的指明了
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {PlayGroundImmutableProperties.class, PlayGroundProperties.class})
public class SpringBootPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPlaygroundApplication.class, args);
    }

}
