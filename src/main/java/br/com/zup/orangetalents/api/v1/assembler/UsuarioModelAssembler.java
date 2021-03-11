package br.com.zup.orangetalents.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.orangetalents.api.v1.model.UsuarioModel;
import br.com.zup.orangetalents.domain.model.Usuario;

@Component
public class UsuarioModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioModel toModel(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioModel.class);
	}
	
}
