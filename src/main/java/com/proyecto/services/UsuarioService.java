package com.proyecto.services;

import com.proyecto.models.Usuario;
import com.proyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Registrar un usuario con encriptación de contraseña
    public boolean registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            return false; // Correo ya registrado
        }
        // Encriptar la contraseña antes de guardarla
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        usuarioRepository.save(usuario);
        return true;
    }

    // Autenticar usuario
    public boolean autenticarUsuario(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        // Verificar si el usuario existe y si la contraseña coincide
        return usuario != null && passwordEncoder.matches(password, usuario.getContraseña());
    }

    public Usuario findByNombre(String nombre) {
        Usuario usuario = usuarioRepository.findByNombre(nombre);
        return usuario;
    }
}
