package br.com.bruno.marllon.proficienciadaw1.piscina;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PiscinaRepository extends JpaRepository<Piscina, Long> {
    List<Piscina> findByEnderecoContainingIgnoreCase(String endereco);
}
