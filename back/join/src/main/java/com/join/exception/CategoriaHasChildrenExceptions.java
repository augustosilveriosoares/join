package com.join.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não é permitido excluir uma Categoria que esta vinculada a um ou mais Produtos")
public class CategoriaHasChildrenExceptions  extends RuntimeException{

	private static final long serialVersionUID = 819934043492933119L;
	
	public CategoriaHasChildrenExceptions(String message) {
	       super(message);
	}
	

}
