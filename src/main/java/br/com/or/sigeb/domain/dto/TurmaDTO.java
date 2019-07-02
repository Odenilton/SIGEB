package br.com.or.sigeb.domain.dto;

import br.com.or.sigeb.domain.Turma;

public class TurmaDTO {
	private Long id;
	private String descricao;
	private Integer cargaHoraria;

	public TurmaDTO(Long id, String descricao, Integer cargaHoraria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
	}

	public TurmaDTO(Turma turma) {
		this.id = turma.getId();
		this.descricao = turma.getDescricao();
		this.cargaHoraria = turma.getCargaHoraria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
