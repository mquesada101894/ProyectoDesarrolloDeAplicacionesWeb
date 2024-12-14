package com.proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/usuario/perfil", "/carrito/**").authenticated() // Rutas protegidas
                .requestMatchers("/**").permitAll() // Todo lo demás permitido
            .and()
            .formLogin()
                .loginPage("/login") // Página personalizada de inicio de sesión
                .permitAll()
            .and()
            .logout()
                .permitAll()
            .and()
            .csrf()
                .disable(); // Opcional: desactiva CSRF si tienes problemas con formularios.

        return http.build();
    }
}

