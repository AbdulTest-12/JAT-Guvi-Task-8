package task8;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			// Open the workbook
			XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Vaseera\\eclipse-workspace\\GuviTask8\\src\\main\\java\\WriteExcel.xlsx");
			
			// Open the sheet
			
			XSSFSheet sheet = book.getSheet("Sheet1");
			
			// get the no.of rows
			
			int rowCount = sheet.getLastRowNum();
			
			// get the column count
			
			int columnCount = sheet.getRow(0).getLastCellNum();
			
			// Create 2D array
			
			String[][] data = new String[rowCount][columnCount];
			
			// Get into each row
			
			for(int i=1; i<=rowCount; i++) {
				
				XSSFRow row = sheet.getRow(i);
				
				// get into the column
				
				for(int j=0; j<columnCount ; j++) {
					
					XSSFCell cell = row.getCell(j);
					
					// read the value
					
					System.out.print(cell.getStringCellValue()+"|");
					
					// to store in array
					
					data[i-1][j]=cell.getStringCellValue();
				}
				
				System.out.println();
			}
			
			System.out.println("Printing from array");
			
			for(String[] row : data) {
				
				for(String x : row) {
					
					System.out.print(x +"|");
				}
				System.out.println();
			}
			
			book.close();

	}

}
