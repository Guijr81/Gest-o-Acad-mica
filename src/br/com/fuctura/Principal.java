package br.com.fuctura;

import static br.com.fuctura.IO.lerEntradaUsuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.fuctura.entidade.Professor;
import br.com.fuctura.entidade.ProfessorDAO;
import oracle.jdbc.OracleDriver;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		 
		 //System.out.println("Digite o valor da chave: ");
		 //String chavePrimaria = lerEntradaUsuario();
		 System.out.println("Digite o nome do professor: ");
		 String nomeDoProfessor = lerEntradaUsuario();
		 
		 //String query = "insert into disciplina values(" + chavePrimaria  + "," + "'" + nomeDaDisciplina + "'" + ")"; 
		 //String consultar = "select * from disciplina";
		 //System.out.println(query);
		 
		 // Load driver class 
		 //1 - Class.forName(driverClassName);
		 DriverManager.registerDriver(new OracleDriver());
		
		 //2 - Obtain a connection 1
		 
		 //Connection con = DriverManager.getConnection(url, username, password);
		 //ConnectionConfig configuracao = new ConnectionConfig("jdbc:oracle:thin:@localhost:1521:xe", "fuctura", "123");
		 //Connection con = ConnectionFactory.getInstance().ConnectionDB(ConnectionType.ORACLE).getConnection(configuracao);
		 
		 //versão mais simples:
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "fuctura", "123"); 
		 
		 // Obtain a statement 
		 Statement st = con.createStatement(); 
		
		 // Execute the query 
		 //int count = st.executeUpdate(query); 
		 //DisciplinaDAO dao = new DisciplinaDAO(con);
		 ProfessorDAO profDAO = new ProfessorDAO();
		 profDAO.setConexao(con);
		 
		 //Inserir professor
		 Professor novo = new Professor();
		 novo.setNome(nomeDoProfessor);
		 profDAO.incluir(novo);
		 
		 //Listar os professores
		 ArrayList<Professor> professores = profDAO.listarTodos();
		 
		 for (Professor professor : professores) {
			System.out.println(professor);
		 }
		 
		 //System.out.println("número de linha inseridas = " + count); 
		
		 // Closing the connection as per the 
		 // requirement with connection is completed 
		 con.close(); 
		 
		 
	}

}
