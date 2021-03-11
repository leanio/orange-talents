package br.com.zup.orangetalents.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.orangetalents.api.v1.model.input.UsuarioInput;
import br.com.zup.orangetalents.domain.model.Usuario;

@Component
public class UsuarioInputDissambler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toDomainObject(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}

}
