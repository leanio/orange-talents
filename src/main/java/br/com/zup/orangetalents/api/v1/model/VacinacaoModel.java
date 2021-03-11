package br.com.zup.orangetalents.api.v1.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacinacaoModel {

	private Long id;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataVacinacao;
	
	private String nomeVacina;
	
	private UsuarioModel usuario;
	
}
