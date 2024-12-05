package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class InicioController {
    @GetMapping("/")
    public String mostrarPaginaPrincipal(Model model) {
       
        return "inicio"; // Nombre de la plantilla Thymeleaf (inicio.html)
    }
}
