package colecao;

import interfaceNegocioDados.CadastroJogadorInterface;

import java.io.IOException;

import dado.RepositorioJogador;
import basica.Jogador;
import excecoes.JogadorJaExistenteException;
import excecoes.JogadorNaoEncontradoException;

public class CadastroJogador implements CadastroJogadorInterface{
	private RepositorioJogador rJogador;
	
	public CadastroJogador() throws IOException {
		rJogador = new RepositorioJogador();
		
	}

	@Override
	public void inserir(Jogador jogador) throws JogadorJaExistenteException, IOException {
		if(this.rJogador.existe(jogador.getNome()))
		{
			throw new JogadorJaExistenteException();
		} else {
			rJogador.inserir(jogador);
		}
		
	}

	@Override
	public void remover(String nome) throws JogadorNaoEncontradoException, IOException {
		if(this.rJogador.existe(nome)) {
			this.rJogador.remover(nome);
		}
		else
		{
			throw new JogadorNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Jogador jogador) throws JogadorNaoEncontradoException, IOException {
		if(this.rJogador.existe(jogador.getNome()))
		{
			this.rJogador.atualizar(jogador);
		}
		else {
			throw new JogadorNaoEncontradoException();
		}
		
	}

	@Override
	public Jogador procurar(String nome) throws JogadorNaoEncontradoException {
		Jogador jogador = null;
		if(this.rJogador.existe(nome))
		{
			jogador = this.rJogador.procurar(nome);
		}
		else
		{
			throw new JogadorNaoEncontradoException();
		}
		return jogador;
	}
}
