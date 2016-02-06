import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class Rankings {
	
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 6;
		perm(num2, num1);
		System.out.println(num2 + " " + num1);
	}
	
	private static void perm(int x, int y) {
		int aux = x;
		x = y;
		y = aux;
	}

}
