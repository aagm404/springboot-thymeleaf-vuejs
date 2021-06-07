package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	// A query abaixo busca todos os usuarios, filtrando pelo atributo
	// "username" que coincide com o username passado como parametro abaixo
	User findByUsername(String username);
	
}
