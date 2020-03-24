package com.vmokrecov.aggregateservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenDTO {

    private static final int ACCURACY = 300 * 1000;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    private Long creationTimestamp = System.currentTimeMillis();

    public boolean isExpired() {
        return System.currentTimeMillis() > creationTimestamp + expiresIn * 1000 - ACCURACY;
    }
}
