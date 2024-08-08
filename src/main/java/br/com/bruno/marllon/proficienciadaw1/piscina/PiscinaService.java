package br.com.bruno.marllon.proficienciadaw1.piscina;

import br.com.bruno.marllon.proficienciadaw1.ValidacaoException;
import br.com.bruno.marllon.proficienciadaw1.cliente.Cliente;
import br.com.bruno.marllon.proficienciadaw1.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiscinaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PiscinaRepository piscinaRepository;

    public void cadastrarPiscina(DadosCadastroPiscina dados) {
        // Buscar o cliente pelo nome
        List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCase(dados.nomeCliente());

        if (clientes.isEmpty()) {
            throw new ValidacaoException("Nome do cliente informado não existe.");
        } else {
            Cliente cliente = clientes.get(0);
            System.out.println(cliente.getCodigo() + " " + cliente.getNome());

            System.out.println(dados.endereco() + " " + dados.tempoMedio());

            piscinaRepository.save(new Piscina(clienteRepository, cliente.getCodigo(), dados.endereco(), dados.tempoMedio()));
        }

    }

/*    public Cliente buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ValidacaoException("Cliente não encontrado com ID: " + idCliente));
    }*/


}
