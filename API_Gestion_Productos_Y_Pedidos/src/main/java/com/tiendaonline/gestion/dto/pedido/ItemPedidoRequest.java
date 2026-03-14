package com.tiendaonline.gestion.dto.pedido;

public class ItemPedidoRequest {
	
	
	private Long productoId;
	private Integer cantidad;
	
	public ItemPedidoRequest() {
		super();
	}

	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

}
