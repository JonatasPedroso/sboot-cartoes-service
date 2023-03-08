package dev.jonataspedroso.sbootcartoesservice.service;

import dev.jonataspedroso.sbootcartoesservice.domain.entity.ClienteCartao;
import dev.jonataspedroso.sbootcartoesservice.repository.ClienteCartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteCartaoService {

	private final ClienteCartaoRepository repository;

	public List<ClienteCartao> listCartoesByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
}
