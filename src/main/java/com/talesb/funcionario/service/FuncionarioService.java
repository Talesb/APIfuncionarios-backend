package com.talesb.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talesb.funcionario.exception.BusinessException;
import com.talesb.funcionario.exception.UserNotFoundException;
import com.talesb.funcionario.model.Funcionario;
import com.talesb.funcionario.model.TipoOperacao;
import com.talesb.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> findAll() {
		try {
			return this.funcionarioRepository.findAll();
		} catch (Exception e) {
			throw new UserNotFoundException("Ocorreu um erro ao recuperar a lista de funcionários.");
		}
	}

	public Funcionario save(Funcionario funcionario) {
		try {
			if (Funcionario.isFuncionarioValido(funcionario)) {
				funcionarioRepository.save(funcionario);
			}
		} catch (Exception e) {
			throw new BusinessException("Ocorreu um erro ao salvar o funcionário.");
		}
		return funcionario;
	}

	public Funcionario getById(int id) {
		Funcionario funcionario;
		try {
			funcionario = funcionarioRepository.findById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("Ocorreu um erro ao recuperar o funcionário com id: " + id);
		}
		return funcionario;
	}

	public void delete(Funcionario funcionario) {
		try {
			if (Funcionario.isFuncionarioValido(funcionario) && funcionario.isPersistido()) {
				funcionarioRepository.delete(funcionario);
			}
		} catch (Exception e) {
			throw new BusinessException("Erro durante a exclusão do funcionário.");
		}
	}

	public void deleteById(int id) {
		try {
			funcionarioRepository.deleteById(id);

		} catch (Exception e) {
			throw new BusinessException("Erro durante a exclusão do funcionário com id: " + id);
		}
	}

}
