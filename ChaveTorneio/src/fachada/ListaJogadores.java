package fachada;

import interfaceNegocioDados.CadastroJogadorInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import basica.Jogador;
import colecao.CadastroJogador;

import excecoes.JogadorJaExistenteException;
import excecoes.JogadorNaoEncontradoException;


public class ListaJogadores {
	private CadastroJogador cJogador;
	
	public ListaJogadores() throws IOException {
		cJogador = new CadastroJogador();
	}
	
	public void adicionarJogador(Jogador jogador) throws JogadorJaExistenteException, IOException {
		try{
			this.cJogador.inserir(jogador);
		}catch(JogadorJaExistenteException ex)
		{
			throw new JogadorJaExistenteException();
		}
	}
	
	public void removerJogador(String nome) throws JogadorNaoEncontradoException, IOException {
		try{
			this.cJogador.remover(nome);
		}catch(JogadorNaoEncontradoException ex)
		{
			throw new JogadorNaoEncontradoException();
		}
	}
	
	public void atualizar(Jogador jogador) throws JogadorNaoEncontradoException, IOException {
		try{
			this.cJogador.atualizar(jogador);
		}catch(JogadorNaoEncontradoException ex)
		{
			throw new JogadorNaoEncontradoException();
		}
	}
	
	public Jogador procurarFuncionario(String nome) throws JogadorNaoEncontradoException
	{
		try{
			return this.cJogador.procurar(nome);
		}catch(JogadorNaoEncontradoException ex)
		{
			throw new JogadorNaoEncontradoException();
		}
	}
}
