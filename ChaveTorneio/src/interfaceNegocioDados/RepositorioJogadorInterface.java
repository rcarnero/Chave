package interfaceNegocioDados;

import java.io.IOException;
import excecoes.JogadorJaExistenteException;
import excecoes.JogadorNaoEncontradoException;

import basica.Jogador;

public interface RepositorioJogadorInterface {
	
	void inserir(Jogador jogador)  throws JogadorJaExistenteException, IOException;
	Jogador procurar(String nome) throws JogadorNaoEncontradoException;
	void remover(String nome) throws JogadorNaoEncontradoException, IOException;
	boolean existe(String nome);
	void atualizar(Jogador jogador) throws JogadorNaoEncontradoException, IOException;
}
