package basica;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MontarChave {
	FileInputStream file;
	private HSSFWorkbook wb;
	private HSSFSheet planilha;
	private HSSFRow jogador;
	private String[] jogadores;
	private int[] pontJogadores;
	private int numJogadores;
	
	public MontarChave() throws IOException {
		file = new FileInputStream("ranking.xls");
		wb = new HSSFWorkbook(file);
		planilha = wb.getSheetAt(0);
		numJogadores = planilha.getLastRowNum()+1;
		jogadores = new String[numJogadores];
		pontJogadores = new int[numJogadores];
	}
	
	public void ordenar() {
		for(int i = 0; i < numJogadores; i++) {
			
		}
	}
	
	/*public void quicksort(int l, int r)	{
		if(l+1 >= r) return;
		int p = l + rand()%(r-l);
		PERM(a[p],a[r-1]);
		int i, k;
		for(i=k=l;i<r-1;i++) {
			if(a[i] < a[r-1]) {
				PERM(a[i],a[k]);
				k++;
			}
		}
		PERM(a[r-1], a[k]);
		quicksort(l,k);
		quicksort(k+1,r);
	}*/
}
