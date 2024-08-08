package br.com.bruno.marllon.proficienciadaw1.cliente;

public record DadosListagemCliente(String nome, String contato, String endereco) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getContato(), cliente.getEndereco());
    }

}
