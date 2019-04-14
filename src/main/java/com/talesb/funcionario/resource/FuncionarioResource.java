package com.talesb.funcionario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talesb.funcionario.model.Funcionario;
import com.talesb.funcionario.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Funcionario> findAll() {
		return this.funcionarioService.findAll();
	}
	 
	

}
