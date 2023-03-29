package ada.projeto.arquitetura.figurinhas.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "figurinha")
@ToString
public class FigurinhaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "imagem", nullable = false, unique = true)
    private String imagem;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "raridade",nullable = false)
    private Raridade raridade;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;
}
