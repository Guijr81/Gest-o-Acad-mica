package br.com.fuctura.entidade;

public class Disciplina {
	private int cod;
	private int codProfessor;
	private String nome;
	
	public Disciplina() {
	
	}
	
	public Disciplina(int cod, int codProfessor, String nome) {
		this.cod = cod;
		this.nome = nome;
		this.codProfessor = codProfessor;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCodProfessor() {
		return codProfessor;
	}

	public void setCodProfessor(int codProfessor) {
		this.codProfessor = codProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
