package com.eduardo.loginwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController {
    @RequestMapping("/customError")
    public String handleErrorInCustomErrorController() {
        // Manejo de errores personalizado
        return "error";
    }
}