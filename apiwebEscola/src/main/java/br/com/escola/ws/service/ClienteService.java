package br.com.escola.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.escola.ws.model.Aluno;

@Service
public class ClienteService {
	
	private Map<Integer,Aluno> alunos = new HashMap<>();
	private Integer proximoId=0;
	
	//Negocios
	
	public Aluno cadastrar(Aluno aluno){
		
		//criar ID
		aluno.setId(proximoId);
		proximoId++;
		
		alunos.put(aluno.getId(), aluno);
		
		return aluno;
		
	}
	
	public Collection<Aluno> buscarTodos(){
		
		return alunos.values();
	}
	
	public void excluir(Aluno aluno){
		alunos.remove(aluno.getId());
	}
	
	public Aluno buscaPorId(Integer id){
		return alunos.get(id);
	}
	
	public Aluno alterar(Aluno aluno){
		alunos.put(aluno.getId(), aluno);
		return aluno;
	}
	
	
	

}
