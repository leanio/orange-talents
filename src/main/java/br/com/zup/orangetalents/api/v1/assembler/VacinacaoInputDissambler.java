package br.com.zup.orangetalents.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.orangetalents.api.v1.model.input.VacinacaoInput;
import br.com.zup.orangetalents.domain.model.Vacinacao;

@Component
public class VacinacaoInputDissambler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Vacinacao toDomainObject(VacinacaoInput vacinacaoInput) {
		return modelMapper.map(vacinacaoInput, Vacinacao.class);
	}
	
}
