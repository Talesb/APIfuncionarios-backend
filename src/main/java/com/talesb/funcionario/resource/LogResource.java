package com.talesb.funcionario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
