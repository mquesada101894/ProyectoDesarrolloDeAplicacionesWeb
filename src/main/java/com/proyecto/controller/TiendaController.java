package com.proyecto.controller;

import com.proyecto.models.Producto;
import com.proyecto.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TiendaController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/tienda")
    public String mostrarTienda(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "tienda";
    }
}
