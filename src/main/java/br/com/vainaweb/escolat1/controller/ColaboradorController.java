package br.com.vainaweb.escolat1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosAtualizados;
import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.repository.ColaboradorRepository;
import br.com.vainaweb.escolat1.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaborador-teste")



// Classe responsavel por receber requisições e retornar respostas
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;
	
	@Autowired
	private ColaboradorRepository repository;

	@GetMapping
	public List<ColaboradorModel> listarTodosColaboradores() {
		return service.encontrarTodos();
	}
	
	@GetMapping("/{id}")// define uma variavel que sera enviada pela URL
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		var response = repository.findById(id)
				.map( resposta -> ResponseEntity.ok(resposta) )
				.orElse(ResponseEntity.notFound().build());
		return response;
	}

	@PostMapping
	public String cadastrar(@RequestBody DadosColaborador dados) {
		return service.cadastrar(dados);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
		var colaborador = repository.getReferenceById(id);
		colaborador.atualizarInfo(dados);
		repository.save(colaborador);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado";
	}
}
