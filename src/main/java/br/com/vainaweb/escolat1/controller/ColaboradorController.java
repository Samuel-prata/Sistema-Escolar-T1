package br.com.vainaweb.escolat1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.service.Colaborador;

@RestController
@RequestMapping("/colaborador-teste")
public class ColaboradorController {
	
	@Autowired
	private Colaborador colaborador;
	
	@GetMapping
	public List<Colaborador> listarColaboradores() {
		return colaborador.encontrarTodoscolaboradores();
	}
	

	@PostMapping
	public String cadastrar(@RequestBody DadosColaborador dados ) {
		colaborador.cadastrarColaborador(dados);
		return "ok";
	}
	
	
}
