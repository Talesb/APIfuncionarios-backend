package com.talesb.funcionario.model;

import java.io.Serializable;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract int getId();

	@Transient
	@JsonIgnore
	public boolean isPersistido() {
		return this.getId() > 0;
	}
}
