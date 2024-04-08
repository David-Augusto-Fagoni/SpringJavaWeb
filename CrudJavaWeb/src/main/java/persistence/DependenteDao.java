package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dependente;

public class DependenteDao {
	private GenericDao gDao;
	
	public DependenteDao(GenericDao gDao) {	
		this.gDao = gDao;
	}
	public List<Dependente> list(String cod) throws SQLException, ClassNotFoundException  {
		List<Dependente> dependentes = new ArrayList<>();
		Connection connection = gDao.getConnection();
		String querySql = "SELECT * FROM dependente WHERE codigo_funcionario = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		preparedStatement.setString(1, cod);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			Dependente dependente = new Dependente();
			dependente.setCodFuncionario(result.getString("codigo_funcionario"));
			dependente.setNome(result.getString("nome_dependente"));
			dependente.setSalario(result.getFloat("salario_dependente"));
			dependentes.add(dependente);
		}
		return dependentes;
	}
}
