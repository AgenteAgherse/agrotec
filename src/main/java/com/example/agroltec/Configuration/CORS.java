package com.example.agroltec.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CORS implements WebMvcConfigurer {

    /**
    * Para implementar una configuración válida entre el front y el back, hay que incluir la 
    * configuración del CORS. En este ejemplo, hay que permitir la comunicación entre el programa
    * y el sitio web o la app donde está el front (En este caso, el front de la aplicación se encuentra
    * en el puerto 5173).
    * Este es un ejemplo básico para brindar permisos de transacciones entre una aplicación realizada en React.js
    * y Spring.
    */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173")
                    .allowedMethods("POST", "GET", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .allowCredentials(true);

                }

        };
}
}
