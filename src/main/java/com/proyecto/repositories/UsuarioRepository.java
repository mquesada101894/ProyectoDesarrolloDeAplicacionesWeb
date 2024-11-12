package com.proyecto.repositories;

import com.proyecto.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método personalizado para buscar un usuario por correo electrónico
    Usuario findByCorreo(String correo);

    // Método para verificar si un correo ya existe en la base de datos
    boolean existsByCorreo(String correo);
}