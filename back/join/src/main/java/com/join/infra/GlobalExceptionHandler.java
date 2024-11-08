
package com.join.infra;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.join.exception.CategoriaHasChildrenExceptions;
import com.join.exception.CategoriaNotFoundException;
import com.join.exception.ProdutoNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CategoriaNotFoundException.class)
	private ResponseEntity<String> categoriaNotFoundException(CategoriaNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não Encontrada");
		
	}
	
	@ExceptionHandler(ProdutoNotFoundException.class)
	private ResponseEntity<String> produtoNotFoundException(ProdutoNotFoundException exception){
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não Encontrado");
	}
	
    @ExceptionHandler(CategoriaHasChildrenExceptions.class)
    public ResponseEntity<String> handleCategoriaHasChildrenException(CategoriaHasChildrenExceptions ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST); 
    }
}
