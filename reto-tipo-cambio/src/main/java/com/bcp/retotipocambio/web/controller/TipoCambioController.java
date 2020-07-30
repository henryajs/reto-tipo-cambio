package com.bcp.retotipocambio.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.retotipocambio.entity.DataTipoCambioEntity;
import com.bcp.retotipocambio.model.DatosActualizarTipoCambioInput;
import com.bcp.retotipocambio.model.DatosTipoCambioInput;
import com.bcp.retotipocambio.model.DatosTipoCambioOutput;
import com.bcp.retotipocambio.model.Resultado;
import com.bcp.retotipocambio.service.TipoCambioService;

@RestController
@RequestMapping("/reto-bcp")
public class TipoCambioController {
	
	@Autowired
	private TipoCambioService tipoCambioService;
	
	@PostMapping("/calcular-tipo-cambio")
	public DatosTipoCambioOutput getTipoCambio(@RequestBody DatosTipoCambioInput input) {
		return tipoCambioService.getTipoCambio(input);
	}
	
	@PostMapping("/actualizar-tipo-cambio")
	public Resultado actualizarTipoCambio(@RequestBody DatosActualizarTipoCambioInput input) {
		Resultado resultado = new Resultado();
		resultado = tipoCambioService.actualizarTipoCambio(input);
		return resultado;
		
	}
	
	@GetMapping("/obtener-data-tipo-cambio")
	public List<DataTipoCambioEntity> obtenerDataTipoCambio(){
		return tipoCambioService.obtenerDataTipoCambio();
	}

}
