package dado;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import basica.Jogador;
import excecoes.JogadorJaExistenteException;
import excecoes.JogadorNaoEncontradoException;
import interfaceNegocioDados.RepositorioJogadorInterface;

public class RepositorioJogador implements RepositorioJogadorInterface {

	private HSSFWorkbook wb;
	private HSSFSheet planilha;
	private int indiceLinha;
	private HSSFRow informacoes;
	private HSSFRow linha;
	private FileOutputStream arquivo;
	private FileInputStream arquivoI;
	private File arq;
	public RepositorioJogador() throws IOException {
		this.arq = new File("ranking.xls");
		
		if(this.arq.exists()) {
			this.arquivoI = new FileInputStream(arq);
			this.wb = new HSSFWorkbook(arquivoI);
			this.planilha = wb.getSheetAt((short)0);
			this.linha = planilha.getRow(this.indiceTotal());
		} else {
			this.arquivo = new FileOutputStream(arq);
			this.wb = new HSSFWorkbook();
			this.planilha = wb.createSheet("Jogadores");
			this.informacoes = planilha.createRow((short)0);
			this.informacoes.createCell(0).setCellValue("Nome");
			this.informacoes.createCell(1).setCellValue("Pontuação");
			this.informacoes.createCell(2).setCellValue("Clube");
			this.wb.write(arquivo);
		}
	
	}
	
	public void inserir(Jogador jogador) throws JogadorJaExistenteException, IOException {
		int i = this.indiceNome(jogador.getNome());
		if(i > this.indiceTotal()) {
			this.indiceLinha = this.planilha.getLastRowNum() + 1;
			this.linha = planilha.createRow((short)this.indiceLinha);
			this.linha.createCell(0).setCellValue(jogador.getNome());
			this.linha.createCell(1).setCellValue(jogador.getPontuacao());
			this.linha.createCell(2).setCellValue(jogador.getClube());
			arquivo = new FileOutputStream(arq);
			wb.write(arquivo);
		} else throw new JogadorJaExistenteException();
	}

	@Override
	public Jogador procurar(String nome) throws JogadorNaoEncontradoException {
		Jogador resposta = null;
		int i = this.indiceNome(nome);
		if(i > this.indiceTotal()) {
			throw new JogadorNaoEncontradoException();
		} else {
			String nomeJogador;
			String clube;
			int pontuacao;
			
			nomeJogador = this.planilha.getRow((short)i).getCell(0).getStringCellValue();
			pontuacao = Integer.parseInt(this.planilha.getRow((short)i).getCell(1).getStringCellValue());
			clube = this.planilha.getRow((short)i).getCell(2).getStringCellValue();
			
			resposta = new Jogador(nomeJogador, clube);
			resposta.setPontuacao(pontuacao);
		}
		return resposta;
	}

	@Override
	public void remover(String nome) throws JogadorNaoEncontradoException, IOException {
		int i = this.indiceNome(nome);

		this.indiceLinha = this.indiceTotal();
		this.planilha.getRow((short)i).getCell(0).setCellValue(this.planilha.getRow(this.indiceLinha).getCell(0).getStringCellValue());
		this.planilha.getRow((short)i).getCell(1).setCellValue(this.planilha.getRow(this.indiceLinha).getCell(1).getNumericCellValue());
		this.planilha.getRow((short)i).getCell(2).setCellValue(this.planilha.getRow(this.indiceLinha).getCell(2).getNumericCellValue());	
		this.planilha.getRow((short)this.indiceLinha).removeCell(this.linha.getCell(0));
		this.planilha.getRow((short)this.indiceLinha).removeCell(this.linha.getCell(1));
		this.planilha.getRow((short)this.indiceLinha).removeCell(this.linha.getCell(2));
			
		arquivo = new FileOutputStream("ranking.xls");
		wb.write(arquivo);
		
	}

	@Override
	public boolean existe(String nome) {
		boolean existe;
		int i = this.indiceNome(nome);
		if(i > this.indiceTotal()) {
			existe = false;
		} else {
			existe = true;
		}
		return existe;
	}

	@Override
	public void atualizar(Jogador jogador) throws JogadorNaoEncontradoException, IOException {
		int i = this.indiceNome(jogador.getNome());
		if(i > this.indiceTotal()) {
			throw new JogadorNaoEncontradoException();
		} else {
			this.planilha.getRow((short)i).getCell(1).setCellValue(jogador.getPontuacao());
			arquivo = new FileOutputStream("ranking.xls");
			wb.write(arquivo);
		}
		
	}
	
	private int indiceNome(String nome) {
		String aux;
		boolean achou = false;
		int indice;
		for(indice = 0; !achou && indice <= (this.planilha.getLastRowNum()); indice++) {
			aux = this.planilha.getRow((short)indice).getCell(0).getStringCellValue();
			if(aux.equals(nome)) {
				achou = true;
			}
		}
		
		return indice;
	}
	
	private int indiceTotal() {
		int indiceTotal = this.planilha.getLastRowNum();
		return indiceTotal;
	}

}
