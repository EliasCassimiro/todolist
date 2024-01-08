package br.com.eliascassimiro.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/primeiraRota")
//HTTP://LOCALHOST:8080/primeiraRota ... 
public class minhaPrimeiraController {

    /**
     * MÉTODOS DE ACESSO DO HTTP
     * GET - BUSCAR INFORMAÇÃO
     * POST - ADICIONAR INFOMAÇÃO
     * PUT - ALTERAR INFORMAÇÃO
     * DELETE - EXCLUIR INFORMAÇÃO
     * PATCH - ALTERAR SOMENTE UMA PARTE DA INFORMAÇÃO
     * 
     */

    // MÉTODO (FUNCIONALIDADE) DE UMA CLASSE
    @GetMapping("/")
    public String primeiraMensagem(){
        return "Funcinou";
    }
}
