package br.com.fuctura.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class OracleConnection implements ConnectionDB {
	private static OracleConnection self;
	
	public static OracleConnection getInstance() {
		if(self == null) {
			self = new OracleConnection(); 
		}
		return self;
	}

	@Override	
	public Connection getConnection(ConnectionConfig config) throws SQLException {
		return DriverManager.getConnection(config.getUrl(), config.getUserName(), config.getPassword()); 
	}
}
