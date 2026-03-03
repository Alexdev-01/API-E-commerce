package com.tiendaonline.gestion.service.impl;

import java.util.List;

import com.tiendaonline.gestion.model.Categoria;
import com.tiendaonline.gestion.repository.CategoriaRepository;

@Service	// Marca esta clase como un componente de servicio en Spring
public class CategoriaServiceImpl {

	private final CategoriaRepository categoriaRepository;

	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> listarTodas() {
		return categoriaRepository.findAll();
	}

}
