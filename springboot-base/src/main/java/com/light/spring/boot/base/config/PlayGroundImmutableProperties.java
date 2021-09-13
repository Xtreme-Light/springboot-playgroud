package com.light.spring.boot.base.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.net.InetAddress;
import java.util.List;

/**
 * 通过构造器的方式来注入不可变的属性
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "special.playground2")
@Getter
public class PlayGroundImmutableProperties {
    private boolean enabled;

    private InetAddress remoteAddress;

    private final Security security;
    public PlayGroundImmutableProperties(boolean enabled, InetAddress remoteAddress, Security security) {
        this.enabled = enabled;
        this.remoteAddress = remoteAddress;
        this.security = security;
    }
    @Getter
    public static class Security {
        private String username;

        private String password;

        private List<String> roles;
        public Security(String username, String password, @DefaultValue("USER") List<String> roles) {
            this.username = username;
            this.password = password;
            this.roles = roles;
        }

    }
}
