package excecoes;

public class JogadorJaExistenteException extends Exception {
	public JogadorJaExistenteException() {
		super("Jogador já cadastrado!");
	}

}
