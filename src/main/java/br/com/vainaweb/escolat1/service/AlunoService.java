package br.com.vainaweb.escolat1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosAlunos;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;

@Service // Classe de serviço gerenciada pelo Spring
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public List<AlunoModel> encontrarTodos() {
		// Método da Repository que faz a query -> SELECT * FROM nome_da_tabela
		return repository.findAll();
	}

	public String cadastrar(DadosAlunos dados) {
		
		var cpfExistente = repository.existsByCpf(dados.cpf());
		var emailExistente = repository.existsByEmail(dados.email());
		
		if(cpfExistente || emailExistente) {
			return "Aluno Já cadastrado em nosso sistema";
		}
		
		repository.save(new AlunoModel(dados.nome(), dados.email(), dados.cpf(),dados.telefone(), dados.curso(), dados.endereco()));
		return "Cadastrado com sucesso";

	}
}
