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

import com.join.model.Categoria;
import com.join.service.CategoriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public Categoria findById(@PathVariable(value = "id") UUID id) {
		return categoriaService.findById(id);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categorias = categoriaService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}
	

	
	@PostMapping()
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		Categoria categoriaSave = categoriaService.save(categoria);
		return ResponseEntity.status(HttpStatus.OK).body(categoriaSave);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@PathVariable(value = "id") UUID id, @RequestBody Categoria categoria) {
		Categoria entity = categoriaService.update(id, categoria);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	

}
