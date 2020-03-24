package com.vmokrecov.aggregateservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloWorldDTO {

    private String helloMessage;
    private String worldMessage;
}
