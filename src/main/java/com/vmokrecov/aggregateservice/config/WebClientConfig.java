package com.vmokrecov.aggregateservice.config;

import com.vmokrecov.aggregateservice.dto.JwtTokenDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    private JwtTokenDTO token;

    private AuthConfigurationProperties configuration;

    public WebClientConfig(AuthConfigurationProperties configuration) {
        this.configuration = configuration;
    }

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .filter(this::authTokenFilter)
                .build();
    }

    protected Mono<ClientResponse> authTokenFilter(ClientRequest request, ExchangeFunction next) {
        if (token == null || token.isExpired()) token = serverAuth();

        return next.exchange(ClientRequest.from(request)
                .header(HttpHeaders.AUTHORIZATION, "Bearer" + token.getAccessToken())
                .build());
    }

    private JwtTokenDTO serverAuth() {
        return WebClient.builder()
                .filter(ExchangeFilterFunctions
                        .basicAuthentication(configuration.getClientId(), configuration.getClientSecret()))
                .build()
                .post()
                .uri(configuration.getAccessTokenUrl())
                .body(BodyInserters.fromFormData("grant_type", configuration.getGrantType())
                        .with("client_id", configuration.getClientId()))
                .exchange()
                .flatMap(response -> response.bodyToMono(JwtTokenDTO.class))
                .block();
    }
}
