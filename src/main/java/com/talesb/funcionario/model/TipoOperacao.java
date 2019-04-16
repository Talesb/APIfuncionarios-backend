package com.talesb.funcionario.model;

public enum TipoOperacao {

	POST("POST", "ENVIO"), //
	PUT("PUT", "ATUALIZACAO"), //
	GET("GET", "RECUPERACAO"), //
	DELETE("DELETE", "EXCLUSAO"); //

	String operacao;

	private TipoOperacao(String operacao, String descricao) {
		this.operacao = operacao;
	}

	public String getOperacao() {
		return operacao;
	}

}
