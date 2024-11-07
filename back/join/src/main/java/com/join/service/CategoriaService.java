package com.join.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.join.exception.CategoriaHasChildrenExceptions;
import com.join.exception.CategoriaNotFoundException;
import com.join.model.Categoria;
import com.join.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public Categoria findById(UUID id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundException());
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria update (UUID id, Categoria entity) {
		var categoria = categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundException());
		categoria.setNome(entity.getNome());
		categoriaRepository.save(categoria);
		return categoria;
	}
	
	public void delete(UUID id){
		var categoria = categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundException());
		if (categoria.getProdutos() != null && !categoria.getProdutos().isEmpty()) {
	        throw new CategoriaHasChildrenExceptions("Não é permitido excluir uma Categoria que está vinculada a um ou mais Produtos");
	    } else {
	        categoriaRepository.delete(categoria);
	    }
		
		
	}
	
	

}
