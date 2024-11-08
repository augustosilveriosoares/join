package com.join.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.join.dto.ProdutoDTO;
import com.join.exception.ProdutoNotFoundException;
import com.join.model.Produto;
import com.join.repository.CategoriaRepository;
import com.join.repository.ProdutoRespository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRespository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public Produto findById(UUID id) {
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException());
		return produto;
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto update (UUID id, Produto produtoDto) {
		//var produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException());
		Optional<Produto> optional = produtoRepository.findById(id);
		Produto produto = null;
		
		if(!optional.isPresent()) {
			throw new ProdutoNotFoundException();
			
		}else {
			produto = optional.get();
		}

		produto.setNome(produtoDto.getNome());
		produto.setSku(produtoDto.getSku());
		produto.setPreco(produtoDto.getPreco());
		produto.setCategoria(produtoDto.getCategoria());
		produtoRepository.save(produto);
		return produto;
	}
	
	public void delete(UUID id){
		var produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException());
		produtoRepository.delete(produto);
		
	}

}
