package com.escola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.escola.model.Alunos;
import com.escola.escola.repository.AlunosRepository;

@RestController
@RequestMapping("/Alunos")
@CrossOrigin("*")
public class AlunosController {
	@Autowired
	private AlunosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Alunos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alunos> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Alunos>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Alunos> aluno(@RequestBody Alunos Aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Aluno));
	}
	@PutMapping
	public ResponseEntity<Alunos> put (@RequestBody Alunos Aluno){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Aluno));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
