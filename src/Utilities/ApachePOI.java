package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {
	
	public XSSFWorkbook wb;
	public ApachePOI() throws Exception {
		File scr=new File("./library/objects.xlsx");
		
		FileInputStream fis =new FileInputStream(scr);
		
		wb=new XSSFWorkbook(fis);
		
		
		
	}
	public String getstringData(String sheetname,int row,int column) {
		
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
	public String getstringData(int sheetindex,int row,int column) {
		
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		
	}
	public double getnumericData(String sheetname,int row,int column) {
		
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		
	}
	
	

}
