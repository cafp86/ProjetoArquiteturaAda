package ada.projeto.arquitetura.figurinhas.repository;

import ada.projeto.arquitetura.figurinhas.model.entity.FigurinhaEntity;
import ada.projeto.arquitetura.figurinhas.model.entity.Raridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FigurinhaRepository extends JpaRepository<FigurinhaEntity,Integer> {
    
    List<FigurinhaEntity> findByAlbumId(Integer albumId);
    
}
