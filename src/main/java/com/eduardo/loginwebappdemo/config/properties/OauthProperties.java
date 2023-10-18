package com.eduardo.loginwebappdemo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth")
public class OauthProperties {
//clase se utiliza para mapear propiedades relacionadas con la configuración de OAuth desde el archivo de propiedades de la aplicación
    private String[] authorizedRedirectUris;

    public String[] getAuthorizedRedirectUris() {
        return authorizedRedirectUris;
    }

    public void setAuthorizedRedirectUris(String[] authorizedRedirectUris) {
        this.authorizedRedirectUris = authorizedRedirectUris;
    }
}