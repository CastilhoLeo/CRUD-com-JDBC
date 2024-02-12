import java.util.Scanner;

public class CadastroMain {
	
	public static void main(String[] args) throws Exception {
		
	Scanner input = new Scanner(System.in);
		
		int opcao;	
		do
		{
			System.out.printf("Selecione a opção desejada:%n"
					+ "1 - Cadastrar usuario%n"
					+ "2 - Consultar cadastros%n"
					+ "3 - Alterar cadastro%n"
					+ "4 - Excluir cadastro%n"
					+ "5 - Sair%n");
			
			opcao = input.nextInt();
			
			switch(opcao)
			{
			case 1:
				Usuario u = new Usuario();
				System.out.println("Insira o id:");
				u.setId(input.nextInt());
				
				System.out.println("Insira o nome:");
				u.setNome(input.next());
	
				
				System.out.println("Insira a idade:");
				u.setIdade(input.nextInt());
				
				System.out.println("Insira o email:");
				u.setEmail(input.next());
				UsuarioDAO.InserirDados(u);
				break;
			
			case 2:
				UsuarioDAO.consultarDados();
				System.out.printf("%n%n");
				break;
				
			case 3:
				UsuarioDAO.alterarDados();
				break;
			case 4:
				UsuarioDAO.excluirDados();
				break;
				
			}
			
		}
		while (opcao!=5);
			
	}

}
