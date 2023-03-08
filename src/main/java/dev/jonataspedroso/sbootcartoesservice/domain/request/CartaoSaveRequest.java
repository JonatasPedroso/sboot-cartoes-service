package dev.jonataspedroso.sbootcartoesservice.domain.request;

import dev.jonataspedroso.sbootcartoesservice.domain.entity.Cartao;
import dev.jonataspedroso.sbootcartoesservice.domain.enumeration.BandeiraCartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoSaveRequest {
	private String nome;
	private BandeiraCartao bandeira;
	private BigDecimal renda;
	private BigDecimal limite;

	public Cartao toModel() {
		return Cartao.builder()
				.nome(nome)
				.bandeira(bandeira)
				.renda(renda)
				.limiteBasico(limite)
				.build();
	}
}
