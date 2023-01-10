package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		wb.close();
		return cell.getStringCellValue();
		
	}
	
	public int getLastRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int latRowCount = sheet.getLastRowNum();
		wb.close();
		return latRowCount;
		
	}
	
	public void createRow(String sheetName, int rowNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		sheet.createRow(rowNumber);
		FileOutputStream fout = new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fout);
		wb.close();
	
	}
	
	public void writeDataToExcelFile(String sheetName, int rowNum, int cellNum, String cellValue) throws EncryptedDocumentException, IOException
	
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		
		if(sheet.getRow(rowNum) != null) {
			sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
		}
		else
		{
			sheet.createRow(rowNum).createCell(cellNum).setCellValue(cellValue);
		}
		
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.createCell(cellNum);
//		cell.setCellValue(cellValue);
		
		FileOutputStream fout = new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fout);
		
		System.out.println("Data written successfully");
		wb.close();
		
		
	}
	
	public void writeDataIntoExcel(String sheetName, HashMap<String, String> credential) throws EncryptedDocumentException, IOException
	{
		int lastRow = this.getLastRowCount(sheetName);
//		this.createRow(sheetName, lastRow+1);
		for (int i = 0; i < credential.size(); i++) {
			String key = this.readDataFromExcel(sheetName, 0, i);
			this.writeDataToExcelFile(sheetName, lastRow + 1, i, credential.get(key));
		}
	}
}
