package com.talesb.funcionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talesb.funcionario.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	List<Funcionario> findAll();

	Funcionario findById(int id);

	List<Funcionario> findByNome(String nome);

}
