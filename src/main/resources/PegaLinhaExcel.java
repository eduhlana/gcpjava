package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.MsgConfig;

public class PegaLinhaExcel {

	public static String[] planilha = new String[12];
	MsgConfig config = new MsgConfig();

	public static void main(String[] args) {

	};

	public String[] Pegalinha(String nometeste) {

		String excel = config.Msg("Excel");

		File file = new File(excel);
		int teste = 0;
		String[] coluna = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" ,"L","M"};

		switch (nometeste) {

		case "Aprovado":
			teste = 1;
			break;
		case "Cancelado":
			teste = 2;
			break;
		case "Encerrado":
			teste = 3;
			break;
		case "Rascunho":
			teste = 4;
			break;
		case "Em Processamento":
			teste = 6;
			break;
		case "Erro no Processamento":
			teste = 7;
			break;
		default:
			teste = 1;
			break;
		}

		try {
			FileInputStream fisPlanilha = new FileInputStream(file);

			try {
				XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);

				XSSFSheet sheet = workbook.getSheetAt(0);

				Row row = sheet.getRow(teste);

				for (int i = 0; i < coluna.length; i++) {

					Cell cell = sheet.getRow(teste).getCell(i);

					switch (cell.getCellTypeEnum()) {

					case STRING:
						planilha[i] = cell.getStringCellValue();
						i = i;
						break;

					case NUMERIC:
						double a = cell.getNumericCellValue();
						String b = String.valueOf(a);
						int tamanho = b.length();
						String c = b.substring(0, tamanho - 2);
						planilha[i] = c;
						i = i;
						break;

					}

				}
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planilha;
	}

}
