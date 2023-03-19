package dev.jonataspedroso.sbootcartoesservice.infraestructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jonataspedroso.sbootcartoesservice.domain.entity.Cartao;
import dev.jonataspedroso.sbootcartoesservice.domain.entity.ClienteCartao;
import dev.jonataspedroso.sbootcartoesservice.domain.entity.DadosSolicitacaoEmissaoCartao;
import dev.jonataspedroso.sbootcartoesservice.repository.CartaoRepository;
import dev.jonataspedroso.sbootcartoesservice.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissaoCartao(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();

            ClienteCartao clienteCartao = ClienteCartao.builder()
                    .cartao(cartao)
                    .cpf(dados.getCpf())
                    .limite(dados.getLimiteLiberado())
                    .build();

            clienteCartaoRepository.save(clienteCartao);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
