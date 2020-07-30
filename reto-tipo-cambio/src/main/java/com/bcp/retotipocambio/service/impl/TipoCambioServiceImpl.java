package com.bcp.retotipocambio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.retotipocambio.dao.ObtenerDataTipoCambioDao;
import com.bcp.retotipocambio.entity.DataTipoCambioEntity;
import com.bcp.retotipocambio.model.DatosActualizarTipoCambioInput;
import com.bcp.retotipocambio.model.DatosTipoCambioInput;
import com.bcp.retotipocambio.model.DatosTipoCambioOutput;
import com.bcp.retotipocambio.model.Resultado;
import com.bcp.retotipocambio.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
	
	@Autowired
	private ObtenerDataTipoCambioDao dao;

	@Override
	public DatosTipoCambioOutput getTipoCambio(DatosTipoCambioInput input) {
		DatosTipoCambioOutput output = new DatosTipoCambioOutput();
		double tipoCambio = 0;
		double montoFinal = 0.0;	
		
		List<DataTipoCambioEntity> lst = (List<DataTipoCambioEntity>) dao.findAll();
		
		tipoCambio = obtenerTipoCambio(lst,input.getMonedaOrigen(), input.getMonedaDestino());
		
		montoFinal = input.getMonto() * tipoCambio;
		
		output.setMontoOriginal(input.getMonto());
		output.setMontoFinal(montoFinal);
		output.setMonedaOrigen(input.getMonedaOrigen());
		output.setMonedaDestino(input.getMonedaDestino());
		output.setTipoCambio(tipoCambio);		
		
		return output;
	}

	@Override
	public Resultado actualizarTipoCambio(DatosActualizarTipoCambioInput input) {
		Resultado resultado = new Resultado();
		DataTipoCambioEntity entity = dao.findByMonedaOrigenAndMonedaDestino(input.getMonedaOrigen(), input.getMonedaDestino());
		
		if (entity == null) {
			resultado.setCodigo(1);
			resultado.setMensaje("No existe moneda.");
			return resultado;
		}
		
		entity.setTipoCambio(input.getTipoCambio());
		 dao.save(entity);	
		 
		 resultado.setCodigo(0);
		 resultado.setMensaje("Se actualizo valor del tipo de cambio.");
		 
		 return resultado;
	}

	@Override
	public List<DataTipoCambioEntity> obtenerDataTipoCambio() {		
		return (List<DataTipoCambioEntity>) dao.findAll();
	}
	
	public double obtenerTipoCambio(List<DataTipoCambioEntity> lst, String monedaOrigen, String monedaDestino) {
		double tipoCambio;
		
		tipoCambio = lst.stream()
				.filter(x -> x.getMonedaOrigen().equalsIgnoreCase(monedaOrigen) && x.getMonedaDestino().equalsIgnoreCase(monedaDestino))
				.findFirst()
				.map(DataTipoCambioEntity::getTipoCambio)
				.orElse(0.0); 
		
		return tipoCambio;	 
	}

}
