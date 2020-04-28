package com.vmokrecov.aggregateservice.controllers;

import com.vmokrecov.aggregateservice.dto.HelloWorldDTO;
import com.vmokrecov.aggregateservice.services.HelloworldService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Api(tags = "AggregateController admin", description = "AggregateController description")
public class AggregateController {

    private HelloworldService helloworldService;

    public AggregateController(HelloworldService helloworldService) {
        this.helloworldService = helloworldService;
    }

    @GetMapping("/helloworld")
    public Mono<HelloWorldDTO> helloworld() {
        return Mono.from(helloworldService.getHelloworld());
    }
}
