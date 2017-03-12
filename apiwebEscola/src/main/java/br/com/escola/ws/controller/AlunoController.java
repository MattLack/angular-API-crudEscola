package br.com.escola.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.escola.ws.model.Aluno;
import br.com.escola.ws.service.ClienteService;

@RestController
public class AlunoController {
	
	@Autowired
	ClienteService clienteservice;
	
	
	
	
	//End points
	
	@RequestMapping(method=RequestMethod.POST,value="/alunos",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
		
		Aluno alunoSalvo = clienteservice.cadastrar(aluno);
		
		return new ResponseEntity<Aluno>(alunoSalvo,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/alunos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Aluno>> ListarAlunos(){
		
		Collection<Aluno> alunosListados = clienteservice.buscarTodos();
		
		return new ResponseEntity<>(alunosListados,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/alunos/{id}")
	public ResponseEntity<Aluno> excluirAluno(@PathVariable Integer id){
		
		Aluno alunoAchou = clienteservice.buscaPorId(id);
		
		if(alunoAchou==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			clienteservice.excluir(alunoAchou);
			return new ResponseEntity<>(HttpStatus.OK);

		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/alunos",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> alterarALuno(@RequestBody Aluno aluno){
		
		Aluno alunoalterado = clienteservice.alterar(aluno);
		return new ResponseEntity<Aluno>(alunoalterado,HttpStatus.OK);
	}
	
}
