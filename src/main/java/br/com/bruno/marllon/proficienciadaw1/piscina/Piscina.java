package br.com.bruno.marllon.proficienciadaw1.piscina;

import br.com.bruno.marllon.proficienciadaw1.ValidacaoException;
import br.com.bruno.marllon.proficienciadaw1.cliente.Cliente;
import br.com.bruno.marllon.proficienciadaw1.cliente.ClienteRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Table(name = "piscina")
@Entity(name = "Piscina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Piscina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String endereco;
    private Integer tempoMedio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
    private Cliente cliente;

    public Piscina(ClienteRepository clienteRepository, Long idCliente, String endereco, Integer tempoMedio) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ValidacaoException("Cliente não encontrado com ID: " + idCliente));

        this.cliente = cliente;
        this.endereco = endereco;
        this.tempoMedio = tempoMedio;
    }
}

