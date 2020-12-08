package com.escola.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.escola.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {
	public List<Alunos> findAllByNomeContainingIgnoreCase (String nome);
}
