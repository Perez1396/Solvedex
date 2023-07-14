package com.solvedex.solvedex.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse() {
    }
    public AuthenticationResponse(String token) {
        this.token = token;
    }

}