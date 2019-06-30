package br.com.or.sigeb.enums;

public enum TipoFuncionario {
	DIRETOR(0, "Diretor"), COORDENADOR(1, "Coordenador"), PROFESSOR(2, "Professor"), OUTRO(3, "Outro");
	private int num;
	private String cargo;

	private TipoFuncionario(int num, String cargo) {
		this.num = num;
		this.cargo = cargo;
	}

	public Integer getNum() {
		return num;
	}

	public String getCargo() {
		return cargo;
	}

	public TipoFuncionario convertToEnum(Integer num) {
		for (TipoFuncionario funcionario : TipoFuncionario.values()) {
			if (funcionario.getNum().equals(num))
				return funcionario;
		}
		throw new RuntimeException("Funcionario n encontrado!");
	}
}
