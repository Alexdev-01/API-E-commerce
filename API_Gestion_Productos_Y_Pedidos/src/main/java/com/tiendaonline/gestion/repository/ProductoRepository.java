package com.tiendaonline.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tiendaonline.gestion.model.Producto;

public interface ProductoRepository  extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

}
