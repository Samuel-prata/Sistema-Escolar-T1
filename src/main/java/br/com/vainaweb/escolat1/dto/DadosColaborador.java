package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Cargo;

public record DadosColaborador(String nome, String cpf, String email, Cargo cargo, EnderecoDTO endereco) {

}
