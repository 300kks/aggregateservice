package com.vmokrecov.aggregateservice.services.impl;

import com.vmokrecov.aggregateservice.aggregators.Aggregator;
import com.vmokrecov.aggregateservice.dto.HelloWorldDTO;
import com.vmokrecov.aggregateservice.services.HelloworldService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HelloworldServiceImpl implements HelloworldService {

    @Value("${services.uri.helloservice}")
    private String helloserviceUri;

    @Value("${services.uri.worldservice}")
    private String worldserviceUri;

    private WebClient client;

    public HelloworldServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<HelloWorldDTO> getHelloworld() {
        Mono<String> hello = getMessage(helloserviceUri);
        Mono<String> world = getMessage(worldserviceUri);

        return hello
                .map(Aggregator::new)
                .zipWith(world)
                .map(t -> t.getT1().withMessage2(t.getT2()))
                .map(Aggregator::build);
    }

    private Mono<String> getMessage(String uri) {
        return client
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);
    }
}
