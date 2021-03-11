package br.com.zup.orangetalents.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.api.v1.assembler.UsuarioInputDissambler;
import br.com.zup.orangetalents.api.v1.assembler.UsuarioModelAssembler;
import br.com.zup.orangetalents.api.v1.model.UsuarioModel;
import br.com.zup.orangetalents.api.v1.model.input.UsuarioInput;
import br.com.zup.orangetalents.domain.model.Usuario;
import br.com.zup.orangetalents.domain.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioInputDissambler usuarioInputDissambler;
	
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel adicionar(@Valid @RequestBody UsuarioInput usuarioInput) {
		Usuario usuario = usuarioInputDissambler.toDomainObject(usuarioInput);
		usuario = usuarioService.salvar(usuario);
		
		return usuarioModelAssembler.toModel(usuario);
	}
	
}
