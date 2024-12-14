package com.proyecto.controller;

import com.proyecto.models.Producto;
import com.proyecto.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Listar todos los productos
    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos"; 
    }
    
    @GetMapping("/productos")
    public String mostrarTienda(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    // Obtener detalles de un producto por ID
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return (Producto) productoService.obtenerProductoPorId(id);
    }
    
    @GetMapping("/ofertas")
    public String mostrarOfertas(Model model) {
        List<Producto> productosEnOferta = productoService.obtenerProductosEnOferta();
        model.addAttribute("productosEnOferta", productosEnOferta);
        return "ofertas"; 
    }
    
    @GetMapping("/contacto")
        public String mostrarContacto() {
        return "contacto";
    }
        
    @GetMapping("/busqueda")
    public String buscarProductos(@RequestParam(value = "q", required = false) String query, Model model) {
        if (query == null || query.trim().isEmpty()) {
            model.addAttribute("error", "Por favor, ingresa un término de búsqueda.");
            return "resultados"; // Muestra una página vacía con el mensaje de error.
        }

        List<Producto> resultados = productoService.buscarProductosPorNombre(query.trim());
        model.addAttribute("productos", resultados); // Pasa los productos al modelo
        model.addAttribute("query", query);          // Pasa el término de búsqueda
        return "resultados"; // Carga la plantilla con los resultados
    }
    
}
