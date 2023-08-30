package hkeller.escolacaesguia.services;

import hkeller.escolacaesguia.models.Visita;
import hkeller.escolacaesguia.repositories.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

  private final VisitaRepository visitaRepository;

  @Autowired
  public VisitaService(VisitaRepository visitaRepository) {
    this.visitaRepository = visitaRepository;
  }

  public List<Visita> getAllVisitas() {
    return visitaRepository.findAll();
  }

  public Visita getVisitaById(long id) {
    return visitaRepository.getReferenceById(id);
  }

}
