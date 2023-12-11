package com.zupedu.bancodigital.domain;

import com.zupedu.bancodigital.adapters.persistence.CadastroNovaPropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//(service)
//Classe que representa a lógica de negócios para criar uma nova proposta
@Service
public class CriaNovaPropostaService {
@Autowired
CadastroNovaPropostaRepository cadastroNovaPropostaRepository;

    public CadastroPropostaModel cadastrarProposta(CadastroPropostaModel novaProposta) {
return cadastroNovaPropostaRepository.save(novaProposta);

    }
}
