package hkeller.escolacaesguia.controllers;

import hkeller.escolacaesguia.models.Visita;
import hkeller.escolacaesguia.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/visitas")
public class VisitaController {

  private final VisitaService visitaService;

  @Autowired
  public VisitaController(VisitaService visitaService) {
    this.visitaService = visitaService;
  }

  @GetMapping()
  public String listVisitas(Model model) {
    List<Visita> visitas = visitaService.getAllVisitas();
    model.addAttribute("visitas", visitas);
    return "visita/listagem";
  }

  @GetMapping("/cadastrar")
  public String cadastrarVisita() {
    return "visita/cadastro";
  }

  @GetMapping("/editar/{id}")
  public String editarVisita(@PathVariable Long id, Model model) {
    Visita visita = visitaService.getVisitaById(id);
    model.addAttribute("visita", visita);
    return "visita/editar";
  }

  @GetMapping("/visualizar/{id}")
  public String visualizarVisita(@PathVariable Long id, Model model) {
    Visita visita = visitaService.getVisitaById(id);
    model.addAttribute("visita", visita);
    return "visita/visualizar";
  }

}
