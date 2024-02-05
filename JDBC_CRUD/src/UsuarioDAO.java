import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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

	public static void consultarDados(){
		
		Connection con = null;
		PreparedStatement stm = null;
		String sql = "Select * from usuarios";
		
		try
		{
			con = ConectarBD.conectar();
			stm = con.prepareStatement(sql);
		
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				System.out.printf("id: %d - nome: %s - idade: %d - email: %s", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
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

	public static void alterarDados(){
	
		Connection con = null;
		PreparedStatement stm = null;
		String sql = "UPDATE usuarios SET nome = ? WHERE id = ?";
		Scanner input= new Scanner(System.in);
		
		try
		{
		con = ConectarBD.conectar();
		stm = con.prepareStatement(sql);
		System.out.println("Digite o id a ser alterado: ");
		stm.setInt(2,input.nextInt());
		
		System.out.println("Digite o novo nome: ");
		stm.setString(1, input.next());
		stm.execute();	

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
				if(stm!=null)
					stm.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public static void excluirDados() {
		
		Connection con = null;
		PreparedStatement stm = null;
		String sql = "DELETE FROM usuarios WHERE id = ?";
		Scanner input = new Scanner(System.in);
		
		try
		{
		con = ConectarBD.conectar();
		stm = con.prepareStatement(sql);
		System.out.println("Digite o id do cadastro a ser exluido");
		stm.setInt(1, input.nextInt());
		stm.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
				if (stm!=null)
					stm.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}

