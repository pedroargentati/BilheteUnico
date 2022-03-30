
public class Usuario {

	// atributos ou propriedades ou variáveis de instância
	private String nome;
	private String cpf;
	private String tipo;

	// método construtor para inicializar os atributos do objeto no momento da
	// instanciação
	// 1a --> não tem nenhum tipo
	// 2a --> nome do construtor é o mesmo nome da classe
	public Usuario(String nome, String cpf, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
