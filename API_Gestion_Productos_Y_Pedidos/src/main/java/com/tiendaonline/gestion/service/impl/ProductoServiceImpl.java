package com.tiendaonline.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiendaonline.gestion.model.Producto;
import com.tiendaonline.gestion.repository.ProductoRepository;
import com.tiendaonline.gestion.service.ProductoService;
import org.springframework.stereotype.Service;


@Service	// Marca esta clase como un componente de servicio en Spring
// Implementa la interfaz ProductoService para proporcionar la lógica de negocio relacionada con los productos
public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Producto crearProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizarProducto(Long id, Producto producto) {
		Producto existente = obtenerPorId(id);

		existente.setNombre(producto.getNombre());
		existente.setDescripcion(producto.getDescripcion());
		existente.setPrecio(producto.getPrecio());
		existente.setStock(producto.getStock());
		existente.setCategoria(producto.getCategoria());

		return productoRepository.save(existente);
	}

	@Override
	public void eliminarProducto(Long id) {
		Producto producto = obtenerPorId(id);
		producto.setActivo(false); 
		productoRepository.save(producto);
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	}

	@Override
	public List<Producto> listarTodos() {
		return productoRepository.findAll();
	}

}
