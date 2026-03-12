package com.tiendaonline.gestion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaonline.gestion.model.Producto;
import com.tiendaonline.gestion.service.ProductoService;

@RestController  // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("{/productos}")  // Ruta base para las operaciones relacionadas con productos
public class ProductoController {
	
	public final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	//Acceso Admin
	@PostMapping
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		return ResponseEntity.ok(productoService.crearProducto(producto));
	}
	
	//Acceso public
	@GetMapping
	public ResponseEntity<List<Producto>> listarProductos() {
		return ResponseEntity.ok(productoService.listarTodos());
	}
	
	//Acceso public
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerproductos(@PathVariable Long id) {
		return ResponseEntity.ok(productoService.obtenerPorId(id));
	}
	
	//Acceso Admin
	@PutMapping("/{id}")
	public ResponseEntity<Producto> actualizarProductos(@PathVariable Long id,@RequestBody Producto producto) {
		return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
	}
	
	//Acceso Admin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {	
		productoService.eliminarProducto(id);
		return ResponseEntity.noContent().build();
	}
	
}
