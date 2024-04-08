package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {
	private Connection c;
	
	public Connection getConnection () throws ClassNotFoundException, SQLException{
		String hostName = "localhost";
		String dbName = "spring_funcionario";
		String user = "usuarioDB";
		String senha = "123456";
        c = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s",
                hostName, dbName, user, senha));
    return c;
	}
}
