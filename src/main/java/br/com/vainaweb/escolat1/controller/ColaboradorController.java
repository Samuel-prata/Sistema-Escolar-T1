package br.com.vainaweb.escolat1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador-teste")

// Classe responsavel por receber requisições e retornar respostas
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@GetMapping
	public List<ColaboradorModel> listarTodosColaboradores() {
	
		return service.encontrarTodos();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public String cadastrar(@RequestBody DadosColaborador dados) {
		return service.cadastrar(dados);

	}
	
	public boolean allNum() {
	
		String num = "1234";
		
		for(int i = 0; i < num.length(); i++ ) {
			if(!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
