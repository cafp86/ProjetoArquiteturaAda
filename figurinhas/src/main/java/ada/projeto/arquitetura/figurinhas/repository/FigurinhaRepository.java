package ada.projeto.arquitetura.figurinhas.repository;

import ada.projeto.arquitetura.figurinhas.model.entity.FigurinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FigurinhaRepository extends JpaRepository<FigurinhaEntity,Integer> {
}
