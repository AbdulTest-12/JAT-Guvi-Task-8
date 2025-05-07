package task8;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Creating the workbook
		XSSFWorkbook book = new XSSFWorkbook();

		//creating the sheet
		XSSFSheet sheet = book.createSheet("Sheet1");

		//Storing the data in sheet1
		Object [][] data = {

				{"Name","Age","Email"},
				{"Jhon Doe",30,"jhon@test.com"},
				{"Jane Doe",28,"jhon@test.com"},
				{"Bob Smith",35,"jacky@example.com"},	
				{"Swapnil",37,"swapnil@example,com"}
		};
		//Put data in sheet
		int rowCount = 0;
		// for each to get into each row

		for(Object[] row1 : data) {

			XSSFRow row = sheet.createRow(rowCount++);

			int columnCount=0;

			// for each to get into each columns

			for(Object col : row1) {

				XSSFCell cell = row.createCell(columnCount++);

				// Checking the type of data and making  the entry
				if(col instanceof String) {

					cell.setCellValue((String)col);

				} else  if (col instanceof Integer) {

					cell.setCellValue((Integer)col);
				}
			}

		}

		try {
			FileOutputStream output = new FileOutputStream("C:\\Users\\Vaseera\\eclipse-workspace\\GuviTask8\\src\\main\\java\\WriteExcel.xlsx");
			book.write(output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		book.close();
	}

}

