package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.services.ObterListaTutoresServico;

@RestController
@RequestMapping("rest/tutores")
public class TutorRestController {
    @Autowired
    ObterListaTutoresServico obterListaTutoresServico;

    @GetMapping()
    public Page<User> get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return obterListaTutoresServico.execute(page, size);
    }
}
