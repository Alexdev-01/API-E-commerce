package com.tiendaonline.gestion.service.impl;

import org.springframework.stereotype.Service;

import com.tiendaonline.gestion.service.AuthResponse;
import com.tiendaonline.gestion.service.AuthService;
import com.tiendaonline.gestion.service.LoginRequest;
import com.tiendaonline.gestion.service.RegisterRequest;

@Service	// Marca esta clase como un servicio de Spring, lo que permite su gestión y uso en otras partes de la aplicación
public class AuthServiceImpl implements AuthService {

	@Override
	public AuthResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthResponse login(LoginRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
