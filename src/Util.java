import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Util {

	public static final int N = 5;

	// Array para armazenar os objetos do tipo Bilhete
	BilheteUnico[] bilhete = new BilheteUnico[N];
	int posicao = 0;

	public void consultarBilhete() {
		String cpf;
		int indice;

		cpf = showInputDialog("Informe o CPF que deseja consultar: ");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, "CPF " + cpf + " n�o cadastrado.");
		} else {
			showMessageDialog(null, "\nUsu�rio: " + bilhete[indice].usuario.nome + "\nSaldo:  R$ " + bilhete[indice].getSaldo() + "\nTipo: " + bilhete[indice].usuario.tipo);
		}
	}
	
// m�todo que, quando chamado, verifca qual tipo de bilhete do usu�rio e desconta o valor da passagem de seu saldo.
	public void passarNaCatraca() {
		String cpf;
		int indice;

		cpf = showInputDialog("Informe seu CPF: ");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, "CPF " + cpf + " n�o cadastrado.");
		} else {
			if (bilhete[indice].getSaldo() > 0) {
				bilhete[indice].passarNaCatraca();
				showMessageDialog(null, bilhete[indice].usuario.nome + " o seu saldo ap�s passar na catraca � de: R$" + bilhete[indice].getSaldo());
			} else {
				showMessageDialog(null, "Voc� n�o possui saldo suficiente! Saldo atual : R$" + bilhete[indice].getSaldo());
			}
		}
	}

	// m�todo para cadastrar bilhete.
	public void carregarBilhete() {
		String cpf;
		int indice;

		cpf = showInputDialog("Informe seu CPF: ");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, "CPF " + cpf + " n�o cadastrado.");
		} else {
			int valor;
			valor = parseInt(showInputDialog("Informe o valor que deseja carregar: R$ "));
			bilhete[indice].carregar(valor);
			showMessageDialog(null, bilhete[indice].usuario.nome + " o seu saldo foi para: R$" + bilhete[indice].getSaldo());
		}
	}

	// m�todo para consultar saldo de um usu�rio
	public void consultarSaldo() {
		String cpf;
		int indice;

		cpf = showInputDialog("Informe seu CPF: ");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, "CPF " + cpf + " n�o cadastrado.");
		} else {
			showMessageDialog(null,
					bilhete[indice].usuario.nome + " o seu saldo � de: R$" + bilhete[indice].getSaldo());
		}
	}

	// m�todo para pesquisar um usui�rio pelo cpf dentro do array - retorna a
	// posi��o do array se econtrar o usu�rio ou -1 caso contr�rio
	public int pesquisar(String cpf) {
		int aux = -1;
		for (int i = 0; i < posicao; i++) {
			if (bilhete[i].usuario.cpf.equalsIgnoreCase(cpf)) {
				aux = i;
				break;
			}
		}
		return aux;
	}

	// m�todo para cadastrar um novo bilehte no array.
	public void cadastrarBilhete() {
		String nome, tipo, cpf;
		int indice;

		if (posicao >= bilhete.length) {
			showMessageDialog(null, "Sistema inoperante (sem vaga).");
		} else {
			cpf = showInputDialog("Informe seu cpf");
			indice = pesquisar(cpf);
			if (indice == -1) {
				nome = showInputDialog("Informe o seu nome: ");
				tipo = showInputDialog("Informe o tipo (estudante / professor / normal): ");
				bilhete[posicao] = new BilheteUnico(nome, cpf, tipo);
				posicao++;
			} else {
				showMessageDialog(null, "O CPF " + cpf + " j� est� cadastrado.");
			}
		}

	}

	public void menuPrincipal() {
		String aux = "Escolha uma op��o:\n1. Administrador \n2. Usu�rio \n3. Finalizar";
		int escolha = 0;
		do {

			escolha = parseInt(showInputDialog(aux));
			if (escolha > 3 || escolha < 1) {
				showMessageDialog(null, "Op��o inv�lida");
			} else if (escolha == 1) {
				menuAdministrador();
			} else if (escolha == 2) {
				menuUsuario();
			}

		} while (escolha != 3);
	}

	public void menuAdministrador() {
		String aux = "Escolha uma op��o:\n\n1. Cadastrar bilhete\n2. Consultar bilhete\n3. Sair";
		int escolha;

		do {
			escolha = parseInt(showInputDialog(aux));
			if (escolha < 1 || escolha > 3) {
				showConfirmDialog(null, "Op��o inv�lida");
			} else if (escolha == 1) {
				cadastrarBilhete();
			} else if(escolha == 2) {
				consultarBilhete();
			}

		} while (escolha != 3);
	}

	public void menuUsuario() {
		String aux = "Escolha uma op��o:\n\n1. Consultar o saldo\n2. Carregar bilhete\n3. Passar na catraca \n4. Finalizar";
		int opcao;

		do {
			opcao = parseInt(showInputDialog(aux));
			if (opcao < 1 || opcao > 4) {
				showConfirmDialog(null, "Op��o inv�lida");
			} else if (opcao == 1) {
				consultarSaldo();
			} else if (opcao == 2) {
				carregarBilhete();
			} else if (opcao == 3) {
				passarNaCatraca();
			}

		} while (opcao != 4);
	}

}
