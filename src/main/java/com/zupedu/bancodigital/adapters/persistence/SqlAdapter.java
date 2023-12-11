package com.zupedu.bancodigital.adapters.persistence;

import com.zupedu.bancodigital.domain.CadastroPropostaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlAdapter {
    private final CadastroNovaPropostaRepository cadastraNovaPropostaRepository;

    @Autowired
    public SqlAdapter(CadastroNovaPropostaRepository cadastraNovaPropostaRepository) {
        this.cadastraNovaPropostaRepository = cadastraNovaPropostaRepository;
    }

    public CadastroPropostaModel salva(CadastroPropostaModel cadastroProposta) {
        return cadastraNovaPropostaRepository.save(cadastroProposta);
    }
}
