package com.eduardo.loginwebappdemo.payload;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String accesToken;
    private String tokenType = "Beaner";
}
