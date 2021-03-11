package br.com.zup.orangetalents.api.v1.model.input;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@NotBlank(message = "Deve ser informado o nome do usuário")
	private String nome;
	
	@NotBlank(message = "CPF não deve estar em branco")
	@CPF(message = "CPF não é valido")
	private String cpf;
	
	@Size(min = 3, message = "O e-mail deve ter o tamanho maior ou igual a 3")
	@Email(message = "E-mail não é valido")
	private String email;

	@NotNull(message = "Deve ser informado uma data de nascimento")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;

}
