package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hkeller.escolacaesguia.dtos.VisitaDto;
import hkeller.escolacaesguia.dtos.RequisicaoCadastroVisitaDto;
import hkeller.escolacaesguia.services.CadastrarVisitaServico;
import hkeller.escolacaesguia.services.DeletarVisitaServico;
import hkeller.escolacaesguia.services.EditarVisitaServico;
import hkeller.escolacaesguia.services.ObterVisitaServico;
import hkeller.escolacaesguia.services.ObterListaVisitasServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/visitas")
public class VisitaController {
  @Autowired
  CadastrarVisitaServico cadastrarVisitaServico;

  @Autowired
  ObterListaVisitasServico obterListaVisitasServico;

  @Autowired
  DeletarVisitaServico deletarVisitaServico;

  @Autowired
  ObterVisitaServico obterVisitaServico;

  @Autowired
  EditarVisitaServico editarVisitaServico;

  @GetMapping("cadastro")
  public String getFormularioCadastro(Model model) {
    RequisicaoCadastroVisitaDto visita = new RequisicaoCadastroVisitaDto();

    model.addAttribute("visita", visita);

    return "visita/cadastro";
  }

  @PostMapping()
  public String post(@Valid @ModelAttribute("visita") RequisicaoCadastroVisitaDto visita, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("visita", visita);

      return "visita/cadastro";
    }

    cadastrarVisitaServico.executar(visita);

    return "redirect:/visitas";
  }

  @GetMapping()
  public String get(HttpServletRequest request, Model model) {
    String baseUrl = ServletUriComponentsBuilder
      .fromRequestUri(request)
      .replacePath(null)
      .build()
      .toUriString();

    model.addAttribute("baseUrl", baseUrl);

    return "visita/listagem";
  }

  @GetMapping("{idVisita}/deletar")
  public String delete(@PathVariable("idVisita") Long id) {
    deletarVisitaServico.execute(id);

    return "redirect:/visitas";
  }

  @GetMapping("{idCao}/editar")
  public String formEditar(@PathVariable("idCao") Long idCao, Model model) {
    VisitaDto caoDto = obterVisitaServico.execute(idCao);

    model.addAttribute("cao", caoDto);

    return "cao/editar";
  }

  @PostMapping("{idCao}/editar")
  public String editar(@PathVariable("idCao") Long idCao, @ModelAttribute("cao") VisitaDto caoDto) {
    caoDto.setId(idCao);

    editarVisitaServico.execute(caoDto);

    return "redirect:/caes";
  }

  @GetMapping("{idCao}/visualizar")
  public String visualizar(@PathVariable("idCao") Long idCao, Model model) {
    VisitaDto caoDto = obterVisitaServico.execute(idCao);

    model.addAttribute("cao", caoDto);

    return "cao/visualizar";
  }
}
