package com.bcp.retotipocambio.service;

import java.util.List;

import com.bcp.retotipocambio.entity.DataTipoCambioEntity;
import com.bcp.retotipocambio.model.DatosActualizarTipoCambioInput;
import com.bcp.retotipocambio.model.DatosTipoCambioInput;
import com.bcp.retotipocambio.model.DatosTipoCambioOutput;
import com.bcp.retotipocambio.model.Resultado;

public interface TipoCambioService {
	
	public DatosTipoCambioOutput getTipoCambio(DatosTipoCambioInput input);
	
	public Resultado actualizarTipoCambio(DatosActualizarTipoCambioInput input);
	
	public List<DataTipoCambioEntity> obtenerDataTipoCambio();

}
