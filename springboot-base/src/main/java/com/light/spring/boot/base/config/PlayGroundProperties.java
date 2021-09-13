package com.light.spring.boot.base.config;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ConfigurationProperties 的好处相比如@Value就是在类型安全上
 * prefix 必须是烤肉式命名，比如my.main-project.person
 * 同样的field可以匹配到烤肉式，小蛇式，驼峰式和大蛇式，比如
 * my.main-project.person.first-name
 * my.main-project.person.firstName
 * my.main-project.person.first_name
 * MY_MAINPROJECT_PERSON_FIRSTNAME
 */
@ConfigurationProperties(prefix = "special.playground")
@Validated
@Data
public class PlayGroundProperties {
    private boolean enabled;
    @NotNull
    private InetAddress remoteAddress;

    private final Security security = new Security();

    private String name;
    @Data
    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
    }
}
