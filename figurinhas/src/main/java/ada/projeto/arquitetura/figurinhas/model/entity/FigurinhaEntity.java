package ada.projeto.arquitetura.figurinhas.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="figurinha")
@ToString
public class FigurinhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="id_album", nullable=false)
    private Integer albumId;

    @Column(name="imagem", nullable=false, unique=true)
    private String imagem;

    @Column(name="descricao", nullable=false)
    private String descricao;

    @Column(name="raridade", nullable=false)
    private Raridade raridade;

    @Column(name="preco", nullable=false)
    private BigDecimal preco;
    
}
