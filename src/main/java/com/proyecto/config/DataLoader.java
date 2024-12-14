package com.proyecto.config;

import com.proyecto.models.Producto;
import com.proyecto.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productoRepository.count() == 0) { // Solo agrega productos si no hay datos
            //productoRepository.save(new Producto("Guitarra", "Instrumento musical", "Instrumentos", 150.0, "guitarra.jpg"));
            //productoRepository.save(new Producto("Micrófono", "Sonido profesional", "Sonido", 50.0, "microfono.jpg"));
            //productoRepository.save(new Producto("Amplificador", "Potencia de sonido", "Sonido", 300.0, "amplificador.jpg"));
            System.out.println("Productos de prueba agregados.");
        } else {
            System.out.println("Ya existen productos en la base de datos.");
        }
    }
}
