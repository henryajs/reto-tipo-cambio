package com.bcp.retotipocambio.model;

public class DatosTipoCambioOutput {

	private double montoOriginal;
	private double montoFinal;
	private String monedaOrigen;
	private String monedaDestino;
	private double tipoCambio;

	public double getMontoOriginal() {
		return montoOriginal;
	}

	public void setMontoOriginal(double montoOriginal) {
		this.montoOriginal = montoOriginal;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(double montoFinal) {
		this.montoFinal = montoFinal;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
