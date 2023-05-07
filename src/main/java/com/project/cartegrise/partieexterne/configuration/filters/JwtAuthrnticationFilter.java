package com.project.cartegrise.partieexterne.configuration.filters;

import java.io.IOException;

import com.project.cartegrise.partieexterne.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthrnticationFilter extends OncePerRequestFilter {

    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final UserDetailsService userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userCin;

        // Check if the request is authenticable & has the token
        if(authHeader == null || authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        // Extract info from token
        jwt = authHeader.substring(7);
        userCin = jwtService.extractUsername(jwt);

        // Check if user is already logged
        if(userCin != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails UserDetails = this.userDetailsService.loadUserByUsername(userCin);
            // Check if user & token is valid
            if(jwtService.isTokenValide(jwt, UserDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(UserDetails, null, UserDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Update security context holder
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Pass request to the next filter
        filterChain.doFilter(request, response);
    }
    
}
