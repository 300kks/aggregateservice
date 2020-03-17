package com.vmokrecov.aggregateservice.aggregators;

import com.vmokrecov.aggregateservice.dto.HelloWorldDTO;

public class Aggregator {
    private String message1;
    private String message2;

    public Aggregator(String message1) {
        this.message1 = message1;
    }

    public Aggregator withMessage2(String message2) {
        this.message2 = message2;
        return this;
    }

    public HelloWorldDTO build() {
        return new HelloWorldDTO(message1, message2);
    }
}