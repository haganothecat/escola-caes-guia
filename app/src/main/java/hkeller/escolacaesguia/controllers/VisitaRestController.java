package hkeller.escolacaesguia.controllers;

import hkeller.escolacaesguia.models.Visita;
import hkeller.escolacaesguia.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/visitas")
public class VisitaRestController {

  @Autowired
  private VisitaService visitaService;
  @GetMapping("/pagina")
  public Page<Visita> get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
    return visitaService.pagina(page, size);
  }
}
