package br.com.vainaweb.escolat1.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.dto.DadosAtualizados;
import br.com.vainaweb.escolat1.dto.EnderecoDTO;
import br.com.vainaweb.escolat1.enums.Cargo;
import br.com.vainaweb.escolat1.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotação que diz que essa classe é uma entidade
@Entity
@Table(name = "tb_alunos" )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// será a classe responsavel pela entidade
public class AlunoModel {
	

	@Id //Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true) //Formata as colunas
	@Email //Valida isso como um email
	private String email;
	
	@Column(unique = true)
	@CPF //Valida como um CPF
	private String cpf;
	private String telefone;
	private Curso curso;
	
	@Embedded //Incorpora a classe na entidade (OS ATRIBUTOS DESSA CLASSA SERÃO PARTE DA MINHA TABELA)
	private Endereco endereco;
	
	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public AlunoModel(String nome, String email, String cpf, String telefone, Curso curso, EnderecoDTO endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.curso = curso;
		this.telefone = telefone;
		this.endereco = new Endereco(endereco.cep(), endereco.logradouro(), endereco.bairro(), endereco.cidade(), endereco.complemento(), endereco.numero());
	}

	//|------------------------------------------- MÉTODOS --------------------------------|
	
	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.email = dados.email()!= null ? dados.email() : this.email;
	}
	
}

