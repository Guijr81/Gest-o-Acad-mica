package br.com.fuctura.entidade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.fuctura.connection.ConnectionConfig;
import br.com.fuctura.connection.ConnectionFactory;
import br.com.fuctura.connection.ConnectionType;

public class DisciplinaDAO {

	private Connection conexao;
	
	public DisciplinaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserir(Disciplina disciplina) throws SQLException {
		String query = "insert into disciplina values(" + disciplina.getCod()  + "," + disciplina.getCodProfessor()  + "," + "'" + disciplina.getNome() + "'" + ")"; 
		System.out.println(query);
		Statement st = conexao.createStatement();
		int count = st.executeUpdate(query);
		System.out.println("número de linha inseridas = " + count); 
	}
	
	public ArrayList<Disciplina> listarTodos() throws SQLException {
		//consulta que será executada
		String query = "select * from disciplina"; 
		
		//cria a planilha que irá aguardar os comandos
		Statement st = conexao.createStatement();
		
		//executa a consulta e retorna um objeto contendo um tabela virtual.
		ResultSet rs = st.executeQuery(query);
		
		//cria uma estrutura de lista que vai ter todas as linha da consulta.
		ArrayList<Disciplina> todos = new ArrayList<Disciplina>();
		
		while(rs.next()) {
			//para cada linha da consulta crie um objeto do tipo disciplina.
			//extrair os dados da coluna.
			int cod = rs.getInt("cod");
			int codProfessor = rs.getInt("codprofessor");
			String nomeDisciplina = rs.getString("nome");
			
			//cria um objeto com os dados da tabela.
			Disciplina d = new Disciplina(cod, codProfessor, nomeDisciplina); 
			
			//adiciona o objeto criado na coleção.
			todos.add(d);
		}
		
		return todos;
	}
	
	public void atualizar(Disciplina d) throws SQLException {
		String query = "update disciplina set ? where cod = " + d.getCod(); 
		
		Statement st = conexao.createStatement();
		
		st.executeUpdate(query);
	}
	
	public void excluir(Disciplina d) throws SQLException {
		String query = "delete disciplina where cod = " + d.getCod(); 
		
		Statement st = conexao.createStatement();
		
		st.executeUpdate(query);
	}
	
	public static void main(String[] args) throws SQLException {
		ConnectionConfig configuracao = 
				new ConnectionConfig("jdbc:oracle:thin:@localhost:1521:xe", 
						"fuctura", 
						"123");
		
		Connection conexao = ConnectionFactory.
				getInstance().
				ConnectionDB(ConnectionType.ORACLE).
				getConnection(configuracao);
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(conexao);
		
		Disciplina d = new Disciplina(789, 1, "arquitetura");
		
		//disciplinaDAO.inserir(d);
		
		ArrayList<Disciplina> resultado = disciplinaDAO.listarTodos();
		for (Disciplina disciplina : resultado) {
			System.out.println(disciplina.getNome());
		}
	}
}
