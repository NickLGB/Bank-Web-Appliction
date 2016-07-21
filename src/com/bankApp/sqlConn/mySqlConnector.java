package com.bankApp.sqlConn;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class mySqlConnector {
	
	public static Connection conn;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn;
        MysqlDataSource ds = new MysqlDataSource();
        
        ds.setServerName("db4free.net");
        ds.setUser("vlad95");
        ds.setPassword("123456");
        ds.setDatabaseName("bankapp");
        
        ds.setPortNumber(3306);
        conn = (Connection) ds.getConnection();
        
		
		return conn;
	}
}
