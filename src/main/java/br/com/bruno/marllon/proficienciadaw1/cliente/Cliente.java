package br.com.bruno.marllon.proficienciadaw1.cliente;

import br.com.bruno.marllon.proficienciadaw1.piscina.Piscina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nome;
    private String endereco;
    private String contato;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.contato = dados.contato();
        this.endereco = dados.endereco();
    }
}
