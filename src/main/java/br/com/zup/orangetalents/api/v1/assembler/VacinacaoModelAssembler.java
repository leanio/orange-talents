package br.com.zup.orangetalents.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.orangetalents.api.v1.model.VacinacaoModel;
import br.com.zup.orangetalents.domain.model.Vacinacao;

@Component
public class VacinacaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public VacinacaoModel toModel(Vacinacao vacinacao) {
		return modelMapper.map(vacinacao, VacinacaoModel.class);
	}
	
}
