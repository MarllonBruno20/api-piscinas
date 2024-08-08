package br.com.bruno.marllon.proficienciadaw1.piscina;


public record DadosListagemPiscina(String nomeCliente, String endereco, Integer tempoMedio) {

    public DadosListagemPiscina(Piscina piscina){
        this(piscina.getCliente().getNome(), piscina.getEndereco(), piscina.getTempoMedio());
    }


}
