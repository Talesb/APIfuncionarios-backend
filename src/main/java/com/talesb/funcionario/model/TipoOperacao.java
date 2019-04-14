package com.talesb.funcionario.model;

public enum TipoOperacao {

	POST("ENVIO"), //
	PUT("ATUALIZACAO"), //
	GET("RECUPERACAO"), //
	DELETE("EXCLUSAO"); //

	String operacao;

	private TipoOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getOperacao() {
		return operacao;
	}
	
	
}
