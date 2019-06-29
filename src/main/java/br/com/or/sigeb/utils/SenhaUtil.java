package br.com.or.sigeb.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class SenhaUtil {

	public static String gerarBcrypt(String senha) {
		if (senha == null)
			return senha;

		return getBCrypt().encode(senha);
	}

	public static boolean senhaValida(String senha, String senhaEncoded) {
		return getBCrypt().matches(senha, senhaEncoded);
	}

	private static BCryptPasswordEncoder getBCrypt() {
		return new BCryptPasswordEncoder();
	}

}