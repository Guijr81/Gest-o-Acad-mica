package br.com.fuctura.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDB {
	public Connection getConnection(ConnectionConfig config) throws SQLException;
}
