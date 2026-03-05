package com.tiendaonline.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiendaonline.gestion.model.Pedido;
import com.tiendaonline.gestion.model.Usuario;
import com.tiendaonline.gestion.repository.PedidoRepository;
import com.tiendaonline.gestion.service.PedidoService;

//Implementación de la interfaz PedidoService, que maneja la lógica de negocio relacionada con los pedidos
@Service	// Marca esta clase como un componente de servicio en Spring
public class PedidoServiceImpl implements PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	
	@Override
	public Pedido crearPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public List<Pedido> obtenerPedidosUsuario(Usuario usuario) {
		return pedidoRepository.findByUsuario(usuario);
	}

	@Override
	public List<Pedido> obtenerTodos() {
		return pedidoRepository.findAll();
	}
	
	
	

}
