package com.talesb.funcionario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.talesb.funcionario.exception.UserNotFoundException;
import com.talesb.funcionario.model.Funcionario;
import com.talesb.funcionario.model.TipoOperacao;
import com.talesb.funcionario.service.FuncionarioService;
import com.talesb.funcionario.service.LogService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

	private String PATH = "/funcionario";

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private LogService logService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Funcionario> findAll() {
		logService.GenerateLog(TipoOperacao.GET,PATH);
		return this.funcionarioService.findAll();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Funcionario funcionario) {
		logService.GenerateLog(TipoOperacao.POST, PATH);
		this.funcionarioService.save(funcionario);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getId()).toUri()).build();

	}

	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Funcionario update(@PathVariable int id, @RequestBody Funcionario funcionario) {
		logService.GenerateLog(TipoOperacao.PUT, PATH.concat("/" + id));
		Funcionario funcAux = this.funcionarioService.getById(id);
		if (funcAux != null) {
			funcionario.setId(funcAux.getId());
		} else {
			throw new UserNotFoundException("Não é possível atualizar um funcionário inexistente");
		}

		this.funcionarioService.save(funcionario);

		return funcionario;

	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Funcionario getById(@PathVariable int id) {
		logService.GenerateLog(TipoOperacao.GET, PATH.concat("/" + id));
		return this.funcionarioService.getById(id);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestBody Funcionario funcionario) {
		logService.GenerateLog(TipoOperacao.DELETE, PATH);
		this.funcionarioService.delete(funcionario);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		logService.GenerateLog(TipoOperacao.DELETE, PATH.concat("/" + id));
		this.funcionarioService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
