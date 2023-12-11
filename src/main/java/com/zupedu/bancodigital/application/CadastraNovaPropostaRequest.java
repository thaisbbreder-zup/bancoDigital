package com.zupedu.bancodigital.application;

import com.zupedu.bancodigital.domain.CadastraNovaProposta;
import com.zupedu.bancodigital.domain.CadastroPropostaModel;
import com.zupedu.bancodigital.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastraNovaPropostaRequest implements CadastraNovaProposta {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    private String complemento;


    @Override
    public CadastroPropostaModel toModel() {
        return new CadastroPropostaModel(nome, cpf, email, new Endereco(logradouro, numero, cep, cidade, estado, complemento));
    }

}

