import java.util.Random;

public class BilheteUnico {

	// atributos ou propriedades ou variáveis de instância

	private int numero;
	private double saldo;
	private double valorDaPassagem;
	Usuario usuario;

	// método construtor para inicializar os atributos do objeto

	public BilheteUnico(String nome, String cpf, String tipo) {
		Random gerador = new Random();
		this.numero = gerador.nextInt(10000);
		this.saldo = 0;
		this.valorDaPassagem = 4.40;
		this.usuario = new Usuario(nome, cpf, tipo);
	}

	public double getSaldo() {
		return saldo;
	}

	// metodo para carregar o bilhete unico.
	public void carregar(double valor) {
		saldo += valor;
	}

	public boolean passarNaCatraca() {
		boolean auxiliar = false;

		if (usuario.getTipo().equalsIgnoreCase("Normal")) {
			if (saldo >= valorDaPassagem) {
				saldo -= valorDaPassagem;
				auxiliar = true;
			}
		} else {
			if (saldo >= valorDaPassagem / 2) {
				saldo -= valorDaPassagem / 2;
				auxiliar = true;
			}
		}
		return auxiliar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValorDaPassagem() {
		return valorDaPassagem;
	}

	public void setValorDaPassagem(double valorDaPassagem) {
		this.valorDaPassagem = valorDaPassagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

}
