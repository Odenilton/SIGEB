package br.com.or.sigeb.enums;

public enum Disciplina {
	PORTUGUES(0, "Portugues"), MATEMATICA(1, "Matemática"), INGLES(2, "Inglês");

	private int num;
	private String nome;

	private Disciplina(int num, String nome) {
		this.num = num;
		this.nome = nome;
	}

	public Integer getNum() {
		return num;
	}

	public String getNome() {
		return nome;
	}
}
