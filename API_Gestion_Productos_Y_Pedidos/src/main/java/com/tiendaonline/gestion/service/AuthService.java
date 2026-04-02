package com.tiendaonline.gestion.service;

import com.tiendaonline.gestion.dto.auth.AuthResponse;
import com.tiendaonline.gestion.dto.auth.LoginRequest;
import com.tiendaonline.gestion.dto.auth.RegisterRequest;

public interface AuthService {

	AuthResponse register(RegisterRequest request);

	AuthResponse login(LoginRequest request);
	
}
