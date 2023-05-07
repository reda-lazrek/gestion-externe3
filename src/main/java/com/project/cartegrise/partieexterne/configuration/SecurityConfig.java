package com.project.cartegrise.partieexterne.configuration;

import com.project.cartegrise.partieexterne.configuration.filters.JwtAuthrnticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final JwtAuthrnticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        http.csrf()
            .disable()
            // Defining endpoints whitelist
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**", "/**")
            .permitAll()
            // Securing the other endpoints
            .anyRequest()
            .authenticated()
            .and()
            // Configuring session to be stateless (every request should be authenticated)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // Define the authentication provider
            .authenticationProvider(authenticationProvider)
            // Execute our Filter before the spring security filter
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
