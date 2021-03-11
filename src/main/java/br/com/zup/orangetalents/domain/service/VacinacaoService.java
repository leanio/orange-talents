package br.com.zup.orangetalents.domain.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.orangetalents.domain.exception.RegraNegocioException;
import br.com.zup.orangetalents.domain.model.Usuario;
import br.com.zup.orangetalents.domain.model.Vacinacao;
import br.com.zup.orangetalents.domain.repository.VacinacaoRepository;

@Service
public class VacinacaoService {
	
	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Transactional
	public Vacinacao salvar(Vacinacao vacinacao) {
		Long idUsuario = vacinacao.getUsuario().getId();
		
		Usuario usuario = usuarioService.buscarOuFalhar(idUsuario);
		vacinacao.setUsuario(usuario);
		
		LocalDate dataVacinacao = vacinacao.getDataVacinacao();
		LocalDate dataNascimento = usuario.getDataNascimento();
		LocalDate dataHoje = LocalDate.now();
		
		if (dataVacinacao.isAfter(dataHoje)) {
			throw new RegraNegocioException("Data de vacinação que foi informada é posterior ao dia de hoje");
		}
		
		if (dataVacinacao.isBefore(dataNascimento)) {
			throw new RegraNegocioException("Data de vacinação que foi informada ocorreu antes do nascimento do usuário");
		}
		
		return vacinacaoRepository.save(vacinacao);
	}

}

