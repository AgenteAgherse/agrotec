package com.example.agroltec.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CORS implements WebMvcConfigurer {
    
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
