package br.com.fuctura.entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfessorDAO  {
	private Connection conexao;
	
	public ProfessorDAO() {
		
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void incluir(Professor p) throws SQLException {
		String query = "insert into professor values (?, ?)";
		
		PreparedStatement pst = conexao.prepareStatement(query);
		
		pst.setString(2, p.getNome());
		pst.setInt(1, p.getCod());
		
		pst.execute();
	}
	
	public ArrayList<Professor> listarTodos() throws SQLException{
		String query = "select * from professor order by cod";
		
		Statement st = conexao.createStatement();
		
		ResultSet tabelaVirtual = st.executeQuery(query);
		
		ArrayList<Professor> resposta = new ArrayList<Professor>();
		
		while(tabelaVirtual.next()) {
			int cod = tabelaVirtual.getInt("cod");
			String nome = tabelaVirtual.getString("nome");
			
			Professor p = new Professor();
			p.setCod(cod);
			p.setNome(nome);
			
			resposta.add(p);
		}
		
		return resposta;
	}
	
}
