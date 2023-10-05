package hkeller.escolacaesguia.controllers;

import hkeller.escolacaesguia.dtos.RequisicaoCadastroVisitasDto;
import hkeller.escolacaesguia.models.Visita;
import hkeller.escolacaesguia.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cadastro")
    public String cadastroVisita(Model model) {
      RequisicaoCadastroVisitasDto visitas = new RequisicaoCadastroVisitasDto();
      model.addAttribute("visitas", visitas);

      Visita visita = new Visita();
      model.addAttribute("visita", visita);
      return "visita/cadastro";
    }

    @PostMapping("/cadastro")
    public String saveVisita(@ModelAttribute("visita") Visita visita) {
      visitaService.save(visita);
      return "redirect:/visitas";
    }

    @GetMapping("{idVisita}/editar")
    public String editarVisita(@PathVariable Long idVisita, Model model) {
      Visita visita = visitaService.getVisitaById(idVisita);
      model.addAttribute("visita", visita);
      return "visita/editar";
    }
    @PostMapping("{idVisita}/editar")
    public String editarVisita(@PathVariable Long idVisita, @ModelAttribute("visita") Visita visita) {
      Visita visitaOriginal = visitaService.getVisitaById(idVisita);

      visitaOriginal.setNomeEscola(visita.getNomeEscola());
      visitaOriginal.setEmail(visita.getEmail());
      visitaOriginal.setEndereco(visita.getEndereco());
      visitaOriginal.setBairro(visita.getBairro());
      visitaOriginal.setCidade(visita.getCidade());
      visitaOriginal.setCep(visita.getCep());
      visitaOriginal.setTelefoneEscola(visita.getTelefoneEscola());
      visitaOriginal.setNomeResponsavel(visita.getNomeResponsavel());
      visitaOriginal.setTelefoneResponsavel(visita.getTelefoneResponsavel());
      visitaOriginal.setNumeroAlunos(visita.getNumeroAlunos());
      visitaOriginal.setSerieEscolar(visita.getSerieEscolar());
      visitaOriginal.setIdadeAlunos(visita.getIdadeAlunos());
      visitaOriginal.setTextoObjetivo(visita.getTextoObjetivo());
      visitaOriginal.setSimNao(visita.getSimNao());
      visitaOriginal.setDataVisita(visita.getDataVisita());
      visitaOriginal.setHoraVisita(visita.getHoraVisita());
      visitaOriginal.setInformacoesExtras(visita.getInformacoesExtras());

      visitaService.save(visitaOriginal);

      return "redirect:/visitas";
    }

    @GetMapping("{idVisita}/visualizar")
    public String visualizarVisita(@PathVariable Long idVisita, Model model) {
      Visita visita = visitaService.getVisitaById(idVisita);
      model.addAttribute("visita", visita);
      return "visita/visualizar";
    }

    @DeleteMapping("{idVisita}")
    public String excluirVisita(@PathVariable Long idVisita) {
      visitaService.excluirVisita(idVisita);

      return "redirect:/visitas";
    }

}
