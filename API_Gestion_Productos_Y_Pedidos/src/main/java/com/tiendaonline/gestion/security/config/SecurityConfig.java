package com.tiendaonline.gestion.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tiendaonline.gestion.ApiGestionProductosYPedidosApplication;
import com.tiendaonline.gestion.security.jwt.JwtAuthenticationFilter;

@Configuration	// Marca esta clase como una clase de configuración de Spring, lo que permite definir beans y configuraciones relacionadas con la seguridad
@EnableWebSecurity	// Habilita la configuración de seguridad web en la aplicación, lo que permite personalizar la seguridad de las solicitudes HTTP
public class SecurityConfig {

    private final ApiGestionProductosYPedidosApplication apiGestionProductosYPedidosApplication;
	
	private final JwtAuthenticationFilter jwtFilter;

	public SecurityConfig(JwtAuthenticationFilter jwtFilter, ApiGestionProductosYPedidosApplication apiGestionProductosYPedidosApplication) {
		super();
		this.jwtFilter = jwtFilter;
		this.apiGestionProductosYPedidosApplication = apiGestionProductosYPedidosApplication;
	}
	
	@Bean	// Marca este método como un bean de Spring, lo que permite su gestión y uso en otras partes de la aplicación
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeHttpRequests(auth -> auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/productos/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				)
				.sessionManagement (session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean	// Marca este método como un bean de Spring, lo que permite su gestión y uso en otras partes de la aplicación
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
