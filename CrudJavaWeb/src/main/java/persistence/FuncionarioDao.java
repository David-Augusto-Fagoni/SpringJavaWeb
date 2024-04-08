package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;

public class FuncionarioDao {
	private GenericDao gDao;
	
	public FuncionarioDao(GenericDao gDao) {	
		this.gDao = gDao;
	}
	public Funcionario consult (String cod) throws SQLException, ClassNotFoundException {
		Funcionario funcionario = new Funcionario();
		Connection connection = gDao.getConnection();
		String querySql = "SELECT * FROM funcionario WHERE codigo = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		preparedStatement.setString(1, cod);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			funcionario.setCod(cod);
			funcionario.setNome(result.getString("nome"));
			funcionario.setSalario(result.getFloat("salario"));
		}
		return funcionario;
		
	}
}
