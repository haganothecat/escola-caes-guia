package hkeller.escolacaesguia.repositories;

import hkeller.escolacaesguia.models.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
  // Você pode adicionar consultas personalizadas aqui, se necessário
}
