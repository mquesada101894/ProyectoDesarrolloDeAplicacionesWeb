package com.proyecto.repositories;

import com.proyecto.models.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Carrito findByUsuarioId(Long idUsuario);
    Carrito findByUsuarioIdAndProductoId(Long idUsuario, Long idProducto);
}