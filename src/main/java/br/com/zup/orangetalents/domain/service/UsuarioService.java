package br.com.zup.orangetalents.domain.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.orangetalents.domain.exception.RegraNegocioException;
import br.com.zup.orangetalents.domain.exception.UsuarioNaoEncontradoException;
import br.com.zup.orangetalents.domain.model.Usuario;
import br.com.zup.orangetalents.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> usuarioRealCpf = usuarioRepository.findByCpf(usuario.getCpf());
		
		if (usuarioRealCpf.isPresent() && !usuarioRealCpf.get().equals(usuario)) {
			throw new RegraNegocioException("O CPF informado se encontra em uso");
		}
		
		if (usuario.temEmail()) {
			Optional<Usuario> usuarioRealEmail = usuarioRepository.findByEmailIgnoreCase(usuario.getEmail());
			
			if (usuarioRealEmail.isPresent() && !usuarioRealEmail.get().equals(usuario)) {
				throw new RegraNegocioException("O E-mail informado se encontra em uso");
			}
		}
		
		LocalDate dataNascimento = usuario.getDataNascimento();
		LocalDate dataHoje = LocalDate.now();
		
		if (dataNascimento.isAfter(dataHoje)) {
			throw new RegraNegocioException("Data de nascimento que foi informada é posterior ao dia de hoje");
		}
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarOuFalhar(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElseThrow(() -> new UsuarioNaoEncontradoException(idUsuario));
	}

}
