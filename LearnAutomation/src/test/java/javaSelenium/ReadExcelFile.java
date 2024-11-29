package javaSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// identify location of the Excel file
		File f = new File("./TestData/SampleData.xlsx");
		FileInputStream io = new FileInputStream(f);
		// Instance of XSSFWorkbook
		XSSFWorkbook w = new XSSFWorkbook(io);
		
		// Create sheet with the help of XSSFWorkbook
		XSSFSheet s = w.getSheet("EmpDetails");
		
		XSSFRow row = s.getRow(1);
		System.out.println(row.getCell(0));
		
		// handle total rows in XSSFSheet
//		int r = s.getLastRowNum() - s.getFirstRowNum();
		
		// Read the whole excel file
//		for(int i=0; i<=r; i++) {
//			int c = s.getRow(i).getLastCellNum();
//			
//			for(int j=0; j<c; j++) {
//				System.out.println(s.getRow(i).getCell(j).getStringCellValue());
//			}
//		}
		
//		for(int i=0; i<=r; i++) {
//			String nameCellValue = s.getRow(i).getCell(0).getStringCellValue();
////			System.out.println(nameCellValue);
//			
//			String empIDCellValue = s.getRow(i).getCell(1).getStringCellValue();
//			System.out.println(empIDCellValue);
//			
//			String jobRoleCellValue = s.getRow(i).getCell(2).getStringCellValue();
////			System.out.println(jobRoleCellValue);
//			
//			String emailCellValue = s.getRow(i).getCell(3).getStringCellValue();
////			System.out.println(emailCellValue);
//		}
		
		
		
		
		
		// Close the Excel file.
		w.close();
	}

}
