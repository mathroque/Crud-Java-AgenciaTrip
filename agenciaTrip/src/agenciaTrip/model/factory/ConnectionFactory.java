package agenciaTrip.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String usuario = "root";
	private static final String senha = "1234";
	private static final String url_banco = "jdbc:mysql://localhost:3306/agenciatrip";

	public static Connection createConnectionToMySQL() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Connection conexao = DriverManager.getConnection(url_banco, usuario, senha);

		return conexao;
	}

	public static void main(String[] args) throws SQLException {

		Connection conTeste = createConnectionToMySQL();

		if (conTeste != null) {
			System.out.println("Conexão obtida!");
			conTeste.close();

		}

	}

}
