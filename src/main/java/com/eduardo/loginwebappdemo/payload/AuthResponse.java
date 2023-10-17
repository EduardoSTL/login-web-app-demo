package com.eduardo.loginwebappdemo.payload;

import lombok.*;

@Getter
@Setter
public class AuthResponse {
    private String accesToken;
    private String tokenType = "Beaner";

    public AuthResponse(String accesToken) {
        this.accesToken = accesToken;
    }
}
