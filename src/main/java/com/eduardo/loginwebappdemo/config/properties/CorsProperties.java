package com.eduardo.loginwebappdemo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cors")
public class CorsProperties {
    //clase de configuración de propiedades que utiliza la anotación @ConfigurationProperties para leer
    //propiedades específicas de CORS (Cross-Origin Resource Sharing) desde el archivo de propiedades de la aplicación
    private String[] allowedOrigins;

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }
}
