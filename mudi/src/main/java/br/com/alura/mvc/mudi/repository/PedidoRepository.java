package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Cacheable("status")
	public List<Pedido> findByStatus(StatusPedido status, Pageable sort);
	
	@Query("select p from Pedido p join p.usuario u where u.username = :nomeUsuario")
	public List<Pedido> findAllByUsuario(@Param("nomeUsuario") String username);

	@Query("select p from Pedido p join p.usuario u where u.username = :nomeUsuario and p.status = :statusPedido")
	public List<Pedido> findByStatusEUsuario(@Param("statusPedido") StatusPedido status, @Param("nomeUsuario") String name);
}
