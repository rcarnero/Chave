package basica;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Ranking {
	FileInputStream nomes;
	FileWriter file;
	PrintWriter gravar;
	private HSSFWorkbook wb;
	private HSSFSheet planilha;
	private int[] pontuacao;
	private Random rand;
	
	public Ranking() throws IOException {
		file = new FileWriter("Ranking.txt");
		gravar = new PrintWriter(file);
		nomes = new FileInputStream("ranking.xls");
		wb = new HSSFWorkbook(nomes);
		planilha = wb.getSheetAt(0);
		pontuacao = new int[planilha.getLastRowNum()+1];
		rand = new Random();
	}
	
	private void lerArquivo() {
		for(int i = 0; i < (planilha.getLastRowNum()+1); i++) {
			pontuacao[i] = Integer.parseInt(planilha.getRow(i).getCell(1).getStringCellValue());
		}
	}
	
	public void ordenar(int l, int r) {
		if(l+1 >= r) return;
		int p = l + rand.nextInt()%(r-l);
		perm(p, r-1);
		int i, k;
		for(i=k=l;i<r-1;i++) {
			if(pontuacao[i] < pontuacao[r-1]) {
				perm(pontuacao[i],pontuacao[k]);
				k++;
			}
		}
		perm(r-1, k);
		ordenar(l,k);
		ordenar(k+1,r);
		
	}
	
	private void perm(int x, int y) {
		int aux = pontuacao[x];
		pontuacao[x] = pontuacao[y];
		pontuacao[y] = aux;
	}

}
