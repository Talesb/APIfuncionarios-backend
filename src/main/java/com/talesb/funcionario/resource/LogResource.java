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

import com.talesb.funcionario.model.OperLog;
import com.talesb.funcionario.service.LogService;

@RestController
@RequestMapping("/log")
public class LogResource {

	@Autowired
	private LogService logService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OperLog> findAll() {
		return this.logService.findAll();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody OperLog log) {
		this.logService.save(log);
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId()).toUri())
				.build();

	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody OperLog log) {
		this.logService.save(log);
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId()).toUri())
				.build();

	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OperLog getById(@PathVariable int id) {
		return this.logService.getById(id);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestBody OperLog log) {
		this.logService.delete(log);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		this.logService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
