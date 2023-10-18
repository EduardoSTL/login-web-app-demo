package com.eduardo.loginwebappdemo.config.oauth2.user;

import java.util.Map;

public final class GoogleOAuth2UserInfo extends OAuth2UserInfo {
    //encapsula la información específica del proveedor OAuth2 de google
    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}