package com.vmokrecov.aggregateservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("auth")
public class AuthConfigurationProperties {

    private String clientId;
    private String clientSecret;
    private String accessTokenUrl;
    private String grantType;
    private String scope;
}
