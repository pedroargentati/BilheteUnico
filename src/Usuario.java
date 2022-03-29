
public class Usuario {

	// atributos ou propriedades ou variáveis de instância
	String nome;
	String cpf;
	String tipo;

	// método construtor para inicializar os atributos do objeto no momento da
	// instanciação
	// 1a --> não tem nenhum tipo
	// 2a --> nome do construtor é o mesmo nome da classe
	public Usuario(String nome, String cpf, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}

}
