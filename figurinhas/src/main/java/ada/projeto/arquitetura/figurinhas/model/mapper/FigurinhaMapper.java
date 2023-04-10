package ada.projeto.arquitetura.figurinhas.model.mapper;

import ada.projeto.arquitetura.figurinhas.model.dto.FigurinhaDTO;
import ada.projeto.arquitetura.figurinhas.model.entity.FigurinhaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FigurinhaMapper {

    public FigurinhaDTO toDTO(FigurinhaEntity figurinha) {

        FigurinhaDTO figurinhaDTO = new FigurinhaDTO();
        figurinhaDTO.setId(figurinha.getId());
        figurinhaDTO.setAlbumId(figurinha.getAlbumId());
        figurinhaDTO.setImagem(figurinha.getImagem());
        figurinhaDTO.setDescricao(figurinha.getDescricao());
        figurinhaDTO.setRaridade(figurinha.getRaridade());
        figurinhaDTO.setPreco(figurinha.getPreco());
        
        return figurinhaDTO;
    }

    public FigurinhaEntity toEntity(FigurinhaDTO figurinha) {

        FigurinhaEntity figurinhaEntity = new FigurinhaEntity();
        figurinhaEntity.setId(figurinha.getId());
        figurinhaEntity.setAlbumId(figurinha.getAlbumId());
        figurinhaEntity.setImagem(figurinha.getImagem());
        figurinhaEntity.setDescricao(figurinha.getDescricao());
        figurinhaEntity.setRaridade(figurinha.getRaridade());
        figurinhaEntity.setPreco(figurinha.getPreco());

        return figurinhaEntity;
    }

    public List<FigurinhaEntity> toListEntity(List<FigurinhaDTO> listaDTO){
        return listaDTO.stream()
                .map(this::toEntity)
                .toList();
    }

    public List<FigurinhaDTO> toListDTO(List<FigurinhaEntity> listaDTO){
        return listaDTO.stream()
                .map(this::toDTO)
                .toList();
    }

}
