package br.com.bruno.marllon.proficienciadaw1.rota;

import br.com.bruno.marllon.proficienciadaw1.piscina.Piscina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "rota")
@Entity(name = "Rota")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Rota {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Enumerated(EnumType.STRING)
    private Periodo periodo;
    @Enumerated(EnumType.STRING)
    private DiasDaSemana diasDaSemana;
    private Integer tempoMedio;

    @ManyToMany
    @JoinTable(
            name = "rota_piscina",
            joinColumns = @JoinColumn(name = "codigo_rota"),
            inverseJoinColumns = @JoinColumn(name = "codigo_piscina")
    )
    private List<Piscina> piscinas = new ArrayList<>();


}
