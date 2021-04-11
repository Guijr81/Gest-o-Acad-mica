package br.com.fuctura.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory factory;
	
	public static ConnectionFactory getInstance() {
		if(factory == null) {
			factory = new ConnectionFactory();
		}
		return factory;
	}
	
	public ConnectionDB ConnectionDB(ConnectionType type) throws SQLException {
		switch (type) {
		case ORACLE:
			return OracleConnection.getInstance();
		default:
			break;
		}
		return null;
	}
}
