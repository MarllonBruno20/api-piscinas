package br.com.bruno.marllon.proficienciadaw1.controller;

import br.com.bruno.marllon.proficienciadaw1.cliente.DadosListagemCliente;
import br.com.bruno.marllon.proficienciadaw1.piscina.DadosCadastroPiscina;
import br.com.bruno.marllon.proficienciadaw1.piscina.DadosListagemPiscina;
import br.com.bruno.marllon.proficienciadaw1.piscina.PiscinaRepository;
import br.com.bruno.marllon.proficienciadaw1.piscina.PiscinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("piscinas")
public class PiscinaController {

    @Autowired
    private PiscinaService piscinaService;

    @Autowired
    private PiscinaRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<Void> cadastrarPiscina(@RequestBody @Valid DadosCadastroPiscina dados) {
        piscinaService.cadastrarPiscina(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar")
    public List<DadosListagemPiscina> listar(){
        return repository.findAll().stream().map(DadosListagemPiscina::new).toList();
    }

    @GetMapping("/buscarPorEndereco")
    public List<DadosListagemPiscina> buscarPorEndereco(@RequestBody Map<String, String> requestBody) {

        String endereco = requestBody.get("endereco");

        if (endereco == null) {
            throw new IllegalArgumentException("O campo 'endereco' é obrigatório no corpo da requisição.");
        }

        return repository.findByEnderecoContainingIgnoreCase(endereco)
                .stream()
                .map(DadosListagemPiscina::new)
                .toList();
    }

}
