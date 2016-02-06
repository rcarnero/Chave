package GUI;

import java.io.IOException;
import java.util.Scanner;

import basica.*;
import excecoes.*;
import fachada.*;

public class Programa {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner inStr = new Scanner(System.in);
		ListaJogadores rank = null;
		int i = 1;
		try {
			rank = new ListaJogadores();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		do {
			int resposta;
			do {
				System.out.println("1- Adicionar Jogador.\n2- Remover Jogador.");
				resposta = in.nextInt();
			} while(resposta > 2 || resposta < 1);
			
			String nome;
			String clube;
			switch(resposta) {
			case 1:
				System.out.println("Digite o nome do Jogador: ");
				nome = inStr.nextLine();
				System.out.println("Digite o clube o qual pertence:");
				clube = inStr.nextLine();
				
				try{
					rank.adicionarJogador(new Jogador(nome, clube));
				}catch(JogadorJaExistenteException ex)
				{
					System.out.println(ex.getMessage());
				}catch(IOException ex)
				{
					System.out.println("O Excel não pode estar aberto para realizar as modificações");
				}
				break;
			case 2:
				System.out.println("Digite o nome do Jogador: ");
				nome = inStr.nextLine();
				try{
					rank.removerJogador(nome);
				}catch(JogadorNaoEncontradoException ex)
				{
					System.out.print(ex.getMessage());
				}catch(IOException ex)
				{
					System.out.println("O Excel não pode estar aberto para realizar as modificações");
				}
				break;
			}
		
		}while(i != 1);
		
		in.close();
		inStr.close();

	}

}
