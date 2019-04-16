package com.talesb.funcionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talesb.funcionario.model.OperLog;

@Repository
public interface LogRepository extends JpaRepository<OperLog, Integer> {

	List<OperLog> findAll();

	OperLog findById(int id);

	OperLog findByPath(int id);

}
