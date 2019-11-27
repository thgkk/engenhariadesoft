package DominioDoProblema;

public class Jogador {
	
	protected String nome;
	protected int cor = 2;

	public String informarNome() {
		return nome;
	}


	public int informarCor() {
		return cor;
	}

	public void iniciar() {
		cor = 2;
	}

	public void definirNome(String jogador) {
		nome = jogador;
	}

	public void definirComoPrimeiro() {
		cor = 1;
	}

}
