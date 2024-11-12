package com.proyecto.controller;

import com.proyecto.models.Usuario;
import com.proyecto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registro de usuario
    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        boolean registrado = usuarioService.registrarUsuario(usuario);
        if (registrado) {
            return ResponseEntity.ok("Usuario registrado con éxito.");
        } else {
            return ResponseEntity.badRequest().body("Error: El usuario ya existe.");
        }
    }

    // Inicio de sesión de usuario
    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestParam String correo, @RequestParam String password) {
        boolean autenticado = usuarioService.autenticarUsuario(correo, password);
        if (autenticado) {
            return ResponseEntity.ok("Inicio de sesión exitoso.");
        } else {
            return ResponseEntity.status(401).body("Error: Credenciales incorrectas.");
        }
    }
}