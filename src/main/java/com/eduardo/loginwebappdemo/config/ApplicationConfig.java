package com.eduardo.loginwebappdemo.config;

import com.eduardo.loginwebappdemo.config.properties.CorsProperties;
import com.eduardo.loginwebappdemo.config.properties.OauthProperties;
import com.eduardo.loginwebappdemo.config.properties.RsaKeyProperties;
import com.eduardo.loginwebappdemo.config.properties.TokenProperties;
import com.eduardo.loginwebappdemo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(value = { RsaKeyProperties.class, TokenProperties.class,
        CorsProperties.class, OauthProperties.class})
public class ApplicationConfig {
    private final UsuarioService usuarioService;

    @Bean
    public UserDetailsService userDetailsService() {
        return usuarioService;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        return new ProviderManager(authenticationProvider);
    }
}
