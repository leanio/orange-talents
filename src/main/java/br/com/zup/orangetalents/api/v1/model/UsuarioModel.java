package br.com.zup.orangetalents.api.v1.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {
	
	private Long id;

	private String nome;
	
	private String cpf;
	
	private String email;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;

}
