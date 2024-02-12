import java.sql.*;

import com.mysql.cj.PreparedQuery;

public class ConectarBD {
			
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Palmeiras123*";
	private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/cadastro";	
	
	public static Connection conectar() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL_DATABASE, USERNAME, PASSWORD);
		
	}
	
	
}
