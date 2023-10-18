package com.eduardo.loginwebappdemo.config.security;

import com.eduardo.loginwebappdemo.config.properties.TokenProperties;
import com.eduardo.loginwebappdemo.model.entities.User;
import com.eduardo.loginwebappdemo.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class TokenProvider {
//esta clase se encarga de la generación, decodificación y validación de tokens JWT
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;

    private final TokenProperties tokenProperties;

    public String createToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();
        Instant now = Instant.now();

        var jwtClaimsSet = JwtClaimsSet.builder()
                .issuer("API Meu Egresso - UFPA")
                .subject(userPrincipal.getUsername())
                .issuedAt(now)
                .expiresAt(now.plus(tokenProperties.getExpiresHours(), ChronoUnit.HOURS))
                .claim(JwtUtils.NOME.getPropriedade(), userPrincipal.getName())
                .claim(JwtUtils.USER_ID.getPropriedade(), userPrincipal.getId())
                .claim(JwtUtils.SCOPE.getPropriedade(), authentication.getAuthorities());
        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet.build())).getTokenValue();
    }

    public Integer getUserIdFromToken(String token) {
        Jwt jwt = jwtDecoder.decode(token);
        return Integer.parseInt(jwt.getClaim(JwtUtils.USER_ID.getPropriedade()).toString());
    }

    public boolean validateToken(String authToken) {
        return (!isTokenExpired(authToken));
    }

    private boolean isTokenExpired(String token) {
        Instant exp = jwtDecoder.decode(token).getExpiresAt();
        if (exp != null) {
            return exp.isBefore(Instant.now());
        } else {
            return true;
        }
    }
}
