package com.join.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Produto não encontrada")
public class ProdutoNotFoundException extends RuntimeException{


	private static final long serialVersionUID = -2180970340241931708L;

}
