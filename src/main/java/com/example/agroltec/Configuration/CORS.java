package com.example.agroltec.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CORS implements WebMvcConfigurer {
    

    public void addCorsMapping(CorsRegistry cors) {
        cors.addMapping("/**");
    }

}
