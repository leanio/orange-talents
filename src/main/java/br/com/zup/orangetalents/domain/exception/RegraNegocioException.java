package br.com.zup.orangetalents.domain.exception;

public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RegraNegocioException(String mensagem) {
		super(mensagem);
	}
	
}
