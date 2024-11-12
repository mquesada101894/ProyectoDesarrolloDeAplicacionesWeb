package com.proyecto.services;

import com.proyecto.models.Carrito;
import com.proyecto.models.Producto;
import com.proyecto.models.Usuario;
import com.proyecto.repositories.CarritoRepository;
import com.proyecto.repositories.ProductoRepository;
import com.proyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Agregar un producto al carrito de un usuario
    public void agregarProducto(Long idUsuario, Long idProducto, int cantidad) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        Producto producto = productoRepository.findById(idProducto).orElse(null);

        if (usuario != null && producto != null) {
            Carrito carrito = new Carrito();
            carrito.setUsuario(usuario);
            carrito.setProducto(producto);
            carrito.setCantidad(cantidad);
            carritoRepository.save(carrito);
        }
    }

    // Obtener el carrito completo de un usuario
    public Carrito obtenerCarrito(Long idUsuario) {
        return carritoRepository.findByUsuarioId(idUsuario);
    }

    // Eliminar un producto específico del carrito de un usuario
    public void eliminarProducto(Long idUsuario, Long idProducto) {
        Carrito carrito = carritoRepository.findByUsuarioIdAndProductoId(idUsuario, idProducto);
        if (carrito != null) {
            carritoRepository.delete(carrito);
        }
    }
}
