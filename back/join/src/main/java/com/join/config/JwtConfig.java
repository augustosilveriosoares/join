package com.join.config;

import io.jsonwebtoken.SignatureAlgorithm;

public class JwtConfig {

	//Parâmetros para geração do token
	public static final String SECRET_KEY = "46f8543ef4c47335ae537730f4dc495e842c818aaf2d1af8ae6cc49ecb6a90ae";
	public static final SignatureAlgorithm ALGORITMO_ASSINATURA = SignatureAlgorithm.HS256;
	public static final int HORAS_EXPIRACAO_TOKEN = 1;

}
