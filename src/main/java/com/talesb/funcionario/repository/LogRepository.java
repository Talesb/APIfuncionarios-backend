package com.talesb.funcionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.talesb.funcionario.model.Funcionario;
import com.talesb.funcionario.model.OperLog;

@Repository
public interface LogRepository extends JpaRepository<OperLog, Integer> {

	static final String FIND_BY_FUNCIONARIO_ID = "select operlog from OperLog operlog where operlog.funcionarioid = ?1";

	List<OperLog> findAll();

	OperLog findById(int id);

 
	OperLog findByFuncionarioId(int id);

}
