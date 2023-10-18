package com.eduardo.loginwebappdemo.auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
    //inyectar el usuario autenticado actualmente en el método o controlador de Spring MVC.
}
