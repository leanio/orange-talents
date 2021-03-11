package br.com.zup.orangetalents.api.v1.model.input;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacinacaoInput {
	
	@NotBlank
	private String nomeVacina;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataVacinacao;
	
	@NotNull
	@Valid
	private UsuarioIdInput usuario;
	
}
