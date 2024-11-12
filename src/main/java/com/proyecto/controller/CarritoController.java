package com.proyecto.controller;

import com.proyecto.models.Carrito;
import com.proyecto.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // Agregar un producto al carrito
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarProducto(@RequestParam Long idUsuario, @RequestParam Long idProducto, @RequestParam int cantidad) {
        carritoService.agregarProducto(idUsuario, idProducto, cantidad);
        return ResponseEntity.ok("Producto agregado al carrito.");
    }

    // Obtener el contenido del carrito de un usuario
    @GetMapping("/{idUsuario}")
    public Carrito obtenerCarrito(@PathVariable Long idUsuario) {
        return (Carrito) carritoService.obtenerCarrito(idUsuario);
    }

    // Eliminar un producto del carrito
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarProducto(@RequestParam Long idUsuario, @RequestParam Long idProducto) {
        carritoService.eliminarProducto(idUsuario, idProducto);
        return ResponseEntity.ok("Producto eliminado del carrito.");
    }
}