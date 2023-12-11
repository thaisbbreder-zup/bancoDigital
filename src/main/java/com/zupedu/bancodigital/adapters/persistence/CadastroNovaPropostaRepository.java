package com.zupedu.bancodigital.adapters.persistence;

import com.zupedu.bancodigital.domain.CadastroPropostaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CadastroNovaPropostaRepository extends JpaRepository<CadastroPropostaModel, Long> {
    }

