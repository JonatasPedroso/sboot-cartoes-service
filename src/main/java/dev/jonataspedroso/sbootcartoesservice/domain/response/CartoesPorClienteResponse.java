package dev.jonataspedroso.sbootcartoesservice.domain.response;

import dev.jonataspedroso.sbootcartoesservice.domain.entity.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponse {
	private String nome;
	private String bandeira;
	private BigDecimal limiteLiberado;

	public static CartoesPorClienteResponse fromModel(ClienteCartao model) {
		return CartoesPorClienteResponse.builder()
				.nome(model.getCartao().getNome())
				.bandeira(model.getCartao().getBandeira().toString())
				.limiteLiberado(model.getLimite())
				.build();
	}
}
