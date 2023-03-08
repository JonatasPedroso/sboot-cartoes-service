package dev.jonataspedroso.sbootcartoesservice.controller;

import dev.jonataspedroso.sbootcartoesservice.domain.entity.Cartao;
import dev.jonataspedroso.sbootcartoesservice.domain.entity.ClienteCartao;
import dev.jonataspedroso.sbootcartoesservice.domain.request.CartaoSaveRequest;
import dev.jonataspedroso.sbootcartoesservice.domain.response.CartoesPorClienteResponse;
import dev.jonataspedroso.sbootcartoesservice.service.CartaoService;
import dev.jonataspedroso.sbootcartoesservice.service.ClienteCartaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("cartoes")
public class CartaoController {

	private final CartaoService cartaoService;
	private final ClienteCartaoService clienteCartaoService;

	@GetMapping
	public String status () {
		return "ok";
	}

	@PostMapping
	public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request) {
		var cartao = request.toModel();
		cartaoService.save(cartao);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(params = "renda")
	public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda) {
		List<Cartao> cartoesRendaMenorIgual = cartaoService.getCartoesRendaMenorIgual(renda);
		return ResponseEntity.ok(cartoesRendaMenorIgual);
	}

	@GetMapping(params = "cpf")
	public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf) {
		List<ClienteCartao> clienteCartaos = clienteCartaoService.listCartoesByCpf(cpf);
		List<CartoesPorClienteResponse> resultList = clienteCartaos.stream()
				.map(CartoesPorClienteResponse::fromModel)
				.collect(Collectors.toList());
		return ResponseEntity.ok(resultList);
	}
}
