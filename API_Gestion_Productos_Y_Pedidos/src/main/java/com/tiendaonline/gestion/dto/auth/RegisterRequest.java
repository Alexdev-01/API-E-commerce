package com.tiendaonline.gestion.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Solicitud de registro (registro) nuevo usuario en la aplicación.
public class RegisterRequest {
	
	@NotBlank	// Asegura que el campo no esté vacío o solo contenga espacios en blanco
	private String username;
	
	@Email	// Valida que el campo tenga un formato de correo electrónico válido
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;

	public RegisterRequest() {
		super();
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
