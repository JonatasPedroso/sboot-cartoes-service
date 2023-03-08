package dev.jonataspedroso.sbootcartoesservice.service;

import dev.jonataspedroso.sbootcartoesservice.domain.entity.Cartao;
import dev.jonataspedroso.sbootcartoesservice.repository.CartaoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CartaoService {

	private final CartaoRepository repository;

	@Transactional
	public Cartao save(final Cartao cartao) {
		return repository.save(cartao);
	}

	public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
		var rendaBigDecimal = BigDecimal.valueOf(renda);
		return repository.findByRendaLessThanEqual(rendaBigDecimal);
	}
}
