package com.proyecto.services;

import com.proyecto.models.Usuario;
import com.proyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean registrarUsuario(Usuario usuario) {
        // Lógica para registrar usuario
        // Verificar si el correo ya existe
        return !usuarioRepository.existsByCorreo(usuario.getCorreo()) &&
               usuarioRepository.save(usuario) != null;
    }

    public boolean autenticarUsuario(String correo, String password) {
        // Lógica de autenticación
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        return usuario != null && usuario.getContraseña().equals(password);
    }
}