package br.com.zup.orangetalents.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoEncontradoException(Long idUsuario) {
		super(String.format("Usuário de id %d não foi encontrado", idUsuario));
	}

}
