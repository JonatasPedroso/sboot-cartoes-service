package dev.jonataspedroso.sbootcartoesservice.repository;

import dev.jonataspedroso.sbootcartoesservice.domain.entity.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {
	List<ClienteCartao> findByCpf(String cpf);
}
