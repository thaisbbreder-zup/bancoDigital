package com.zupedu.bancodigital.application;

import com.zupedu.bancodigital.domain.CriaNovaPropostaService;
import com.zupedu.bancodigital.domain.CadastroPropostaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cadastro")
public class CadastraNovaPropostaController {

    private final CriaNovaPropostaService criaNovaPropostaService;

    @Autowired
    public CadastraNovaPropostaController(CriaNovaPropostaService criaNovaPropostaService) {
        this.criaNovaPropostaService = criaNovaPropostaService;
    }

    @PostMapping
    public ResponseEntity<CadastroPropostaModel> cadastrarProposta(@RequestBody @Valid CadastraNovaPropostaRequest request) {
        CadastroPropostaModel cadastroProposta = criaNovaPropostaService.cadastrarProposta(request.toModel());
        return new ResponseEntity<>(cadastroProposta, HttpStatus.CREATED);
    }
}
