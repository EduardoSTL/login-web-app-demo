package com.eduardo.loginwebappdemo.enums;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;

@Getter
public enum Authority implements GrantedAuthority {

    ADMIN("ROLE_ADMIN"),
    ENCUESTADOR("ROLE_ENCUESTADOR"),
    CANDIDATO("ROLE_CANDIDATO"),
    USER("ROLE_USER");

    private String code;

    Authority(String code) {
        this.code = code;
    }

    @Override
    public String getAuthority() {
        return this.code;
    }
}
