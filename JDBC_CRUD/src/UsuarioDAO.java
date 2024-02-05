import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class UsuarioDAO {
	
	public static void InserirDados(Usuario usuario) throws Exception {
		
		String sql = "INSERT INTO USUARIOS (id, nome, idade, email) VALUES (?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stm = null;
		
		try
		{
		con = ConectarBD.conectar();
		stm = con.prepareStatement(sql);
		stm.setInt(1, usuario.getId());
		stm.setString(2, usuario.getNome());
		stm.setInt(3, usuario.getIdade());
		stm.setString(4, usuario.getEmail());
		stm.execute();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
			if(stm!=null)
				stm.close();
			if(con!=null)
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

	}

}
