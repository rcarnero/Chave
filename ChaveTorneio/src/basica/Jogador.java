package basica;

public class Jogador {
	private String nome;
	private int pontuacao;
	private String clube;
	private int rank;
	
	public Jogador(String nome, String clube) {
		this.nome = nome;
		this.pontuacao = 0;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public String getClube() {
		return this.clube;
	}
	public String getNome() {
		return this.nome;
	}
	
	public int getPontuacao() {
		return this.pontuacao;
	}
}
