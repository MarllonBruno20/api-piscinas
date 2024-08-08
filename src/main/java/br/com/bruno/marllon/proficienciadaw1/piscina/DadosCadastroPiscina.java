package br.com.bruno.marllon.proficienciadaw1.piscina;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPiscina(
        @NotBlank(message = "{endereco.obrigatorio}")
        String endereco,
        @NotNull(message = "{tempoMedio.obrigatorio}")
        @Min(value = 10, message = "{tempoMedio.invalido}")
        Integer tempoMedio,
        @NotBlank(message = "{nome.obrigatorio}")
        String nomeCliente) {
}
