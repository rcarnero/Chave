package interfaceNegocioDados;

import java.io.IOException;

import basica.Jogador;
import excecoes.JogadorNaoEncontradoException;
import excecoes.JogadorJaExistenteException;

public interface CadastroJogadorInterface {
	
	void inserir(Jogador jogador) throws JogadorJaExistenteException, IOException;
	void remover(String nome) throws JogadorNaoEncontradoException, IOException;
	void atualizar(Jogador jogador) throws JogadorNaoEncontradoException, IOException;
	Jogador procurar(String nome) throws JogadorNaoEncontradoException;

}
