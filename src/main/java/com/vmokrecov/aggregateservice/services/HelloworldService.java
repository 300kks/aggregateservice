package com.vmokrecov.aggregateservice.services;

import com.vmokrecov.aggregateservice.dto.HelloWorldDTO;
import reactor.core.publisher.Mono;

public interface HelloworldService {

    Mono<HelloWorldDTO> getHelloworld();
}
