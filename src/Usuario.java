
public class Usuario {

	// atributos ou propriedades ou vari�veis de inst�ncia
	String nome;
	String cpf;
	String tipo;

	// m�todo construtor para inicializar os atributos do objeto no momento da
	// instancia��o
	// 1a --> n�o tem nenhum tipo
	// 2a --> nome do construtor � o mesmo nome da classe
	public Usuario(String nome, String cpf, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}

}
