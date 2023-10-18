package com.eduardo.loginwebappdemo.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@AllArgsConstructor
@ConfigurationProperties(prefix = "token")
@Getter
@Setter
public class TokenProperties {
    private Integer expiresHours;
    private String domain;

    //esta clase se utiliza para configurar propiedades relacionadas con la gestión de tokens en la aplicación
}
