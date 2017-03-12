package br.com.escola.ws.model;

public class Aluno {

	private Integer id;
	private String Nome;
	private Integer Idade;
	private String Email;
	private String Senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Integer getIdade() {
		return Idade;
	}

	public void setIdade(Integer idade) {
		Idade = idade;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

}
