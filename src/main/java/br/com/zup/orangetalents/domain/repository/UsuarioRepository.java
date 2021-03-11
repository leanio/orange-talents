package br.com.zup.orangetalents.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.orangetalents.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByCpf(String cpf);
	
	Optional<Usuario> findByEmailIgnoreCase(String email);

}
