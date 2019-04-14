package com.talesb.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talesb.funcionario.model.OperLog;
import com.talesb.funcionario.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logsRepository;

	public List<OperLog> findAll() {
		return this.logsRepository.findAll();
	}

}
