package com.bcp.retotipocambio.dao;

import org.springframework.data.repository.CrudRepository;

import com.bcp.retotipocambio.entity.DataTipoCambioEntity;

public interface ObtenerDataTipoCambioDao extends CrudRepository<DataTipoCambioEntity, Long>{
	
	public DataTipoCambioEntity findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

}
