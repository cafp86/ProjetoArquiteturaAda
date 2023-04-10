package ada.projeto.arquitetura.figurinhas.service;

import ada.projeto.arquitetura.figurinhas.model.dto.FigurinhaDTO;
import ada.projeto.arquitetura.figurinhas.model.entity.FigurinhaEntity;
import ada.projeto.arquitetura.figurinhas.model.entity.Raridade;
import ada.projeto.arquitetura.figurinhas.model.mapper.FigurinhaMapper;
import ada.projeto.arquitetura.figurinhas.repository.FigurinhaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FigurinhaService {

    @Autowired
    private FigurinhaRepository repository;

    @Autowired
    private FigurinhaMapper mapper;

    public FigurinhaDTO criar(FigurinhaDTO figurinhaDTO) {
        FigurinhaEntity figurinha = mapper.toEntity(figurinhaDTO);

        figurinha = repository.save(figurinha);

        return mapper.toDTO(figurinha);
    }

    public List<FigurinhaDTO> criarVarias(List<FigurinhaDTO> figurinhasDTO) {
        List<FigurinhaEntity> figurinhas = mapper.toListEntity(figurinhasDTO);

        figurinhas = repository.saveAll(figurinhas);

        return mapper.toListDTO(figurinhas);
    }

    public FigurinhaDTO editar(FigurinhaDTO figurinhaDTO, Integer id) {
        if (repository.existsById(id)) {
            FigurinhaEntity figurinhaEntity = mapper.toEntity(figurinhaDTO);
            figurinhaEntity.setId(id);
            figurinhaEntity = repository.save(figurinhaEntity);

            return mapper.toDTO(figurinhaEntity);
        }

        throw new EntityNotFoundException("Figurinha não encontrada");
    }

    public void deletar(Integer id){
        Optional<FigurinhaEntity> figurinhaEntityOp = repository.findById(id);

        if (figurinhaEntityOp.isPresent()) {
            FigurinhaEntity figurinhaEntity = figurinhaEntityOp.get();
            repository.delete(figurinhaEntity);
            return;
        }

        throw new EntityNotFoundException("Figurinha não encontrada");
    }

    public FigurinhaDTO pegarPorId(Integer id) {
        Optional<FigurinhaEntity> figurinhaEntityOp = repository.findById(id);

        if (figurinhaEntityOp.isPresent()) {
            FigurinhaEntity figurinhaEntity = figurinhaEntityOp.get();
            return mapper.toDTO(figurinhaEntity);
        }

        throw new EntityNotFoundException("Figurinha não encontrada");
    }

    public List<FigurinhaDTO> listar() {
        List<FigurinhaEntity> listaEntities =  repository.findAll();
        return mapper.toListDTO(listaEntities);
    }

    public Object listarPorAlbum(Integer albumId) {
        List<FigurinhaEntity> listaEntities =  repository.findByAlbumId(albumId);
        return mapper.toListDTO(listaEntities);
    }
}
