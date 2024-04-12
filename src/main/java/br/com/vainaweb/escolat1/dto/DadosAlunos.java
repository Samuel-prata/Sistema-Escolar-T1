package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Curso;

public record DadosAlunos(String nome, String cpf, String email, String telefone, Curso curso, EnderecoDTO endereco) {

}
