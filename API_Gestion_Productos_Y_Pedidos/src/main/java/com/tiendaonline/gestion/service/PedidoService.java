package com.tiendaonline.gestion.service;

import java.util.List;

import com.tiendaonline.gestion.dto.pedido.CrearPedidoRequest;
import com.tiendaonline.gestion.model.Pedido;
import com.tiendaonline.gestion.model.Usuario;

public interface PedidoService {
	
	Pedido crearPedido(Pedido pedido);
	
	List<Pedido> obtenerPedidosUsuario(Usuario usuario);
	
	List<Pedido> obtenerTodos();
	
	Pedido crearPedido(CrearPedidoRequest request, String username);

}
