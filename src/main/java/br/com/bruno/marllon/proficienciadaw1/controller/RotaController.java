package br.com.bruno.marllon.proficienciadaw1.controller;

import br.com.bruno.marllon.proficienciadaw1.ValidacaoException;
import br.com.bruno.marllon.proficienciadaw1.piscina.Piscina;
import br.com.bruno.marllon.proficienciadaw1.piscina.PiscinaRepository;
import br.com.bruno.marllon.proficienciadaw1.rota.Rota;
import br.com.bruno.marllon.proficienciadaw1.rota.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rotas")
public class RotaController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @Autowired
    private RotaRepository rotaRepository;

    /*@PutMapping("/adicionarPiscina/{codigoRota}")
    public ResponseEntity<Void> adicionarPiscinaARota(
            @PathVariable(required = false) Long codigoRota,
            @RequestBody DadosAdicaoPiscina dados
    ) {
        Rota rota;

        if (codigoRota != null) {
            // Se o código da rota foi fornecido, utilizar a rota existente
            rota = rotaRepository.findById(codigoRota)
                    .orElseThrow(() -> new ValidacaoException("Rota não encontrada com ID: " + codigoRota));
        } else {
            // Se o código da rota não foi fornecido, criar uma nova rota automaticamente
            rota = criarRotaAutomaticamente();
        }

        // Adicionar a piscina à rota
        adicionarPiscina(rota, dados.getCodigoPiscina());

        // Retornar a resposta
        return ResponseEntity.ok().build();
    }*/



}
