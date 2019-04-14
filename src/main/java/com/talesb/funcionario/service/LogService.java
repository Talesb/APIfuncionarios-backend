package com.talesb.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talesb.funcionario.exception.BusinessException;
import com.talesb.funcionario.exception.LogNotFoundException;
import com.talesb.funcionario.exception.UserNotFoundException;
import com.talesb.funcionario.model.Funcionario;
import com.talesb.funcionario.model.OperLog;
import com.talesb.funcionario.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logsRepository;

	public List<OperLog> findAll() {
		try {
			return this.logsRepository.findAll();
		} catch (Exception e) {
			throw new UserNotFoundException("Ocorreu um erro ao recuperar a lista de logs.");
		}
	}

	public OperLog save(OperLog log) {
		try {
			if (log != null) {
				logsRepository.save(log);
			}
		} catch (Exception e) {
			throw new BusinessException("Ocorreu um erro ao salvar o log.");
		}
		return log;
	}

	public OperLog getById(int id) {
		OperLog log;
		try {
			log = logsRepository.findById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("Ocorreu um erro ao recuperar o log com id: " + id);
		}
		return log;
	}

	public void delete(OperLog log) {
		try {
			if (log != null && log.isPersistido()) {
				logsRepository.delete(log);
			}
		} catch (Exception e) {
			throw new BusinessException("Erro durante a exclusão do log.");
		}
	}

	public void deleteById(int id) {

		try {
			logsRepository.deleteById(id);

		} catch (Exception e) {
			throw new BusinessException("Erro durante a exclusão do log com id: " + id);
		}
	}

	public OperLog findByFuncionario(Funcionario funcionario) {
		OperLog log;
		try {
			log = logsRepository.findByFuncionario(funcionario);

		} catch (Exception e) {
			throw new LogNotFoundException("Erro ao recuperar o log.");
		}

		return log;
	}

	public OperLog findByFuncionario(int funcionarioid) {
		OperLog log;
		try {
			log = logsRepository.findByFuncionarioID(funcionarioid);

		} catch (Exception e) {
			throw new LogNotFoundException("Erro ao recuperar o log.");
		}

		return log;
	}

}
