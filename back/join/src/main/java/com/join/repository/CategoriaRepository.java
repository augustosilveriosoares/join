package com.join.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.join.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID>{
}
