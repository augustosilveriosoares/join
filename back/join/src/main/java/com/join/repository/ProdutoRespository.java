package com.join.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.join.model.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto,UUID>{

}
