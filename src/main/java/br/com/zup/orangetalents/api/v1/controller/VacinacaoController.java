package br.com.zup.orangetalents.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.api.v1.assembler.VacinacaoInputDissambler;
import br.com.zup.orangetalents.api.v1.assembler.VacinacaoModelAssembler;
import br.com.zup.orangetalents.api.v1.model.VacinacaoModel;
import br.com.zup.orangetalents.api.v1.model.input.VacinacaoInput;
import br.com.zup.orangetalents.domain.model.Vacinacao;
import br.com.zup.orangetalents.domain.service.VacinacaoService;

@RestController
@RequestMapping("/v1/vacinacoes")
public class VacinacaoController {

	@Autowired
	private VacinacaoService vacinacaoService;
	
	@Autowired
	private VacinacaoInputDissambler vacinacaoInputDissambler;
	
	@Autowired
	private VacinacaoModelAssembler vacinacaoModelAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VacinacaoModel adicionar(@Valid @RequestBody VacinacaoInput vacinacaoInput) {
		Vacinacao vacinacao = vacinacaoInputDissambler.toDomainObject(vacinacaoInput);
		vacinacao = vacinacaoService.salvar(vacinacao);
		
		return vacinacaoModelAssembler.toModel(vacinacao);
	}
	
}
