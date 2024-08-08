package br.com.bruno.marllon.proficienciadaw1.controller;

import br.com.bruno.marllon.proficienciadaw1.cliente.Cliente;
import br.com.bruno.marllon.proficienciadaw1.cliente.DadosCadastroCliente;
import br.com.bruno.marllon.proficienciadaw1.cliente.DadosListagemCliente;
import br.com.bruno.marllon.proficienciadaw1.cliente.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public List<DadosListagemCliente> listar(){
        return repository.findAll().stream().map(DadosListagemCliente::new).toList();
    }

    @GetMapping("/buscarPorNome")
    public List<DadosListagemCliente> buscarPorNome(@RequestParam String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(DadosListagemCliente::new)
                .toList();
    }

}
