package ada.projeto.arquitetura.figurinhas.model.dto;

import ada.projeto.arquitetura.figurinhas.model.entity.Raridade;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FigurinhaDTO {

    private Integer id;
    
    private Integer albumId;

    private String imagem;

    private String descricao;

    private Raridade raridade;

    private BigDecimal preco;
    
}
