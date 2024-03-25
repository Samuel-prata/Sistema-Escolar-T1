package br.com.vainaweb.escolat1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosColaborador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class Colaborador {
	
//|--------------------------------------------- Inicio Da Model ------------------------------------|
	private List<Colaborador> lista = new ArrayList<Colaborador>();
	
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	
	
	//Construtor 
	public Colaborador(Long id, String nome, String cpf, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

//|--------------------------------------------- Fim Da Model ------------------------------------|
	public boolean cadastrarColaborador(DadosColaborador dados) {
		return lista.add(new Colaborador(dados.id(),dados.nome(),dados.cpf(),dados.endereco()));
	}
	
	public List<Colaborador> encontrarTodoscolaboradores(){
		return lista;
	}
}
