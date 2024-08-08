package br.com.bruno.marllon.proficienciadaw1.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{endereco.obrigatorio}")
        String endereco,
        @NotBlank(message = "{telefone.obrigatorio}")
        String contato) {

}
