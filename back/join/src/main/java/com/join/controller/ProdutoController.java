package com.join.controller;

import java.util.List;
import java.util.UUID;

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

import com.join.dto.ProdutoDTO;
import com.join.model.Produto;
import com.join.service.ProdutoService;

@RestController
@RequestMapping("produto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController{

	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produto = produtoService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	@GetMapping("/{id}")
	public Produto findById(@PathVariable(value = "id") UUID id) {
		return produtoService.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable(value = "id") UUID id, @RequestBody Produto produto) {
		Produto entity = produtoService.update(id, produto);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
