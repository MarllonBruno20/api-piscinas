package br.com.bruno.marllon.proficienciadaw1.rota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroRota(
        @NotNull(message = "Dia da Semana é obrigatório.")
        DiasDaSemana diasDaSemana,
        @NotNull(message = "Período é obrigatório.")
        Periodo periodo,

        @NotBlank
        String piscina,

        Integer tempoMedio ) {
}
